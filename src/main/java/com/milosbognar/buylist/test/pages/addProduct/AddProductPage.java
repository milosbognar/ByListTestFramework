package com.milosbognar.buylist.test.pages.addProduct;

import com.milosbognar.buylist.core.data.models.Item;
import com.milosbognar.buylist.test.elements.addProduct.AddProductElement;
import com.milosbognar.buylist.test.pages.home.HomePage;
import com.milosbognar.buylist.test.pages.settings.SettingsPage;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.milosbognar.buylist.core.utils.TestContext.getContext;
import static com.milosbognar.buylist.core.utils.Utilities.*;

public class AddProductPage extends AddProductElement {

    @Step("When I go back to Home page")
    public HomePage backToHomePage() {
        logStep("When I go back to Home Page");
        hideKeyboard();
        goBack();
        waitForNSeconds(3);
        return new HomePage();
    }

    @Step("When I add an item to the list")
    public AddProductPage addItemToList(Item item) {
        logStep("When I add an item to the list");
        enterText(txtItemName, item.getName());
        enterText(txtPrice, Double.toString(item.getPrice()));
        enterText(txtAmount, Double.toString(item.getAmount()));
        spinnerMeasureUnit.click();
        findElementByTextUsingScroll(item.getMeasureUnit()).click();
        enterText(txtComment, item.getComment());
        spinnerCategory.click();
        findElementByTextUsingScroll(item.getCategory()).click();
        btnAddItem.click();
        return this;
    }

    @Step("When I add items to the list")
    public AddProductPage addItemsToList(List<Item> items) {
        logStep("When I add [%d] items to the list", items.size());
        for (Item item : items) {
            addItemToList(item);
        }
        return this;
    }

    @Step("When I add items to the list and calculate total price")
    public AddProductPage addItemsToListAndCalculateTotalPrice(List<Item> items) {
        logStep("When I add [%d] items to the list and calculate total price", items.size());
        addItemsToList(items);
        calculateTotalPrice(items);
        waitForNSeconds(2);
        return this;
    }

    @Step("When I calculate Total Price")
    private void calculateTotalPrice(List<Item> items) {
        logStep("When I calculate Total price");
        double sumPrice = 0;
        int itemCount = 0;
        for (Item item : items) {
            sumPrice += item.getPrice() * item.getAmount();
            itemCount++;
        }
        sumPrice = Math.round(sumPrice * 100) / 100.0;
        getContext().put("sumPrice", sumPrice);
        getContext().put("itemCount", itemCount);
    }

    @Step("Then total price is correct")
    public boolean isTotalPriceCorrect() {
        logStep("Then total price is correct");
        hideKeyboard();
        waitForNSeconds(2);
        String totalPriceText = lblTotalPrice.getText();
        double totalPrice = Double.parseDouble(totalPriceText.substring(totalPriceText.indexOf(" ") + 1, totalPriceText.lastIndexOf(" ")));
        double sumPrice = (double) getContext().get("sumPrice");
        return sumPrice == totalPrice;
    }

    @Step("When I open Settings page")
    public SettingsPage openSettings() {
        logStep("When I open Settings page");
        btnMenu.click();
        btnSettings.click();
        waitForNSeconds(3);
        return new SettingsPage();
    }

    @Step("When I open Add From My List page")
    public AddFromMyListPage openAddFromMyList() {
        logStep("When I open Add From My List page");
        btnMenu.click();
        btnAddFromMyList.click();
        return new AddFromMyListPage();
    }

    @Step("Then comment element is present")
    public boolean isCommentElementPresent() {
        logStep("Then comment element is present");
        return isElementPresent(lblComment);
    }

    @Step("Then unit element is present")
    public boolean isUnitElementPresent() {
        logStep("Then unit element is present");
        return isElementPresent(lblUnit);
    }

    @Step("Then price element is present")
    public boolean isPriceElementPresent() {
        logStep("Then price element is present");
        return isElementPresent(lblPrice);
    }

    @Step("Then I verify that items are sorted by alphabet")
    public boolean areItemsSortedByAlphabet() {
        logStep("Then I verify that items are sorted by alphabet");
        int itemCount = listItemNames.size();
        for (int i = 0; i < itemCount - 1; i++) {
            for (int j = i + 1; j < itemCount; j++) {
                if (listItemNames.get(i).getText().compareTo(listItemNames.get(j).getText()) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Step("Then I verify that all the items are present")
    public boolean areItemsPresent(List<Item> items) {
        logStep("Then I verify that all the items are present");
        List<String> actualItemNames = new ArrayList<>();
        List<String> expectedItemNames = new ArrayList<>();
        if (listItemNames.size() != items.size())
            return false;
        int itemCount = listItemNames.size();
        for (int i = 0; i < itemCount; i++) {
            actualItemNames.add(listItemNames.get(i).getText());
            expectedItemNames.add(items.get(i).getName());
        }

        Collections.sort(actualItemNames);
        Collections.sort(expectedItemNames);

        return actualItemNames.equals(expectedItemNames);
    }
}
