package com.milosbognar.buylist.test.pages.home;

import com.milosbognar.buylist.test.elements.home.HomePageElement;
import com.milosbognar.buylist.test.pages.settings.SettingsPage;
import com.milosbognar.buylist.test.pages.addProduct.AddProductPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.function.BiFunction;

import static com.milosbognar.buylist.core.utils.Utilities.*;
import static java.lang.String.format;

public class HomePage extends HomePageElement {

    public static final BiFunction<Integer, String, String> LIST_DESCRIPTION = (a, b) -> format("All items: %d Sum: %s £ Date: \\d{1,2}:\\d{1,2}, \\d{1,2}.\\d{1,2}.\\d{1,2}", a, b);

    @Step("When I close popup")
    public void closePopup() {
        logStep("Close popup");
        btnOK.click();
    }

    @Step("When I go back to the Home page")
    public void goBackToHomePage() {
        logStep("Go back to Home page");
        int counter = 3;
        explicitlyWaitForWebElement(hdrBuyList);
        while (!isElementPresent(hdrBuyList) && counter-- != 0) {
            goBack();
            implicitlyWaitForNSeconds(5);
        }
    }

    @Step("Then App is opened")
    public boolean isAppOpened() {
        logStep("Verify that Home page is opened");
        return isElementPresent(hdrBuyList);
    }

    @Step("When I create a new shopping list")
    public AddProductPage createNewList(String listName) {
        logStep("Create [%s] list", listName);
        explicitlyWaitForWebElement(txtListName);
        txtListName.click();
        enterText(txtListName, listName);
        btnCreateList.click();
        return new AddProductPage();
    }

    @Step("When I tap on Remove list button")
    public DeleteModal tapOnRemoveListButton(String listName) {
        logStep("When I remove [%s] list", listName);
        getElementByXPath(btnRemoveForSpecifiedList(listName)).click();
        return new DeleteModal();
    }

    @Step("When I tap on Change list name button")
    public EditNameModal tapOnChangeListNameButton(String listName) {
        logStep("When I tap on change list name button for [%s] list", listName);
        getElementByXPath(btnEditNameForSpecifiedList(listName)).click();
        implicitlyWaitForNSeconds(5);
        return new EditNameModal();
    }

    public HomePage verifyEmptyListElements(String listName) {
        logStep("When I remove [%s] list", listName);
        return verifyListElements(listName, 0, 0);
    }

    @Step("Then empty list elements are displayed")
    public HomePage verifyListElements(String listName, int itemCount, double totalPrice) {
        logStep("Then emtpy list elements are present");
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedTotalPrice = df.format(totalPrice);
        SoftAssertions softAssertions = new SoftAssertions();
        WebElement lblListName = getElementByXPath(lblListNameForSpecifiedList(listName));
        WebElement lblListDetails = getElementByXPath(lblListDetailsForSpecifiedList(listName));
        WebElement btnEditList = getElementByXPath(btnEditNameForSpecifiedList(listName));
        WebElement btnRemoveList = getElementByXPath(btnRemoveForSpecifiedList(listName));

        softAssertions.assertThat(getElementText(lblListName))
                .describedAs("Presence of 'Delete' modal title")
                .isEqualTo(listName);
        softAssertions.assertThat(getElementText(lblListDetails))
                .describedAs("Presence of 'Are you sure?' message")
                .matches(LIST_DESCRIPTION.apply(itemCount, formattedTotalPrice));
        softAssertions.assertThat(isElementPresent(btnEditList))
                .describedAs("Presence of 'Edit list name' button")
                .isTrue();
        softAssertions.assertThat(isElementPresent(btnRemoveList))
                .describedAs("Presence of 'Remove list' button")
                .isTrue();
        softAssertions.assertAll();
        return this;
    }

    @Step("When I open Settings page")
    public SettingsPage openSettings() {
        logStep("When I open Settings page");
        btnMenu.click();
        btnSettings.click();
        return new SettingsPage();
    }
}
