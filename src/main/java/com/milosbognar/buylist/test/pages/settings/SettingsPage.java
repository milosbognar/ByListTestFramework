package com.milosbognar.buylist.test.pages.settings;

import com.milosbognar.buylist.test.elements.settings.SettingsElement;
import com.milosbognar.buylist.test.pages.addProduct.MyListPage;
import com.milosbognar.buylist.test.pages.addProduct.AddProductPage;
import com.milosbognar.buylist.test.pages.home.HomePage;
import io.qameta.allure.Step;

import static com.milosbognar.buylist.core.utils.Utilities.*;

public class SettingsPage extends SettingsElement {

    @Step("When I go back to Add product page")
    public AddProductPage backToAddProductPage() {
        logStep("When I go back to Add product page");
        goBack();
        return new AddProductPage();
    }

    @Step("When I go back to Home page")
    public HomePage backToHomePage() {
        logStep("When I go back to Home page");
        goBack();
        return new HomePage();
    }


    @Step("When I hide units")
    public SettingsPage hideUnits() {
        logStep("When I hide units");
        cbUnits.click();
        waitForNSeconds(5);
        return this;
    }

    @Step("When I hide comments")
    public SettingsPage hideComments() {
        logStep("When I hide comments");
        cbComment.click();
        waitForNSeconds(5);

        return this;
    }

    @Step("When I hide price")
    public SettingsPage hidePrice() {
        logStep("When I hide price");
        cbPrice.click();
        waitForNSeconds(5);
        return this;
    }

    @Step("When I open Sort list modal")
    public SortListModal openSortListMOdal() {
        logStep("When I open Sort list modal");
        btnSortList.click();
        waitForNSeconds(5);
        return new SortListModal();
    }

    @Step("When I open Categories List page")
    public CategoriesListPage openCategoriesList() {
        logStep("When I open Categories List page");
        btnCategoriesList.click();
        waitForNSeconds(5);
        return new CategoriesListPage();
    }

    @Step("When I open My List page")
    public MyListPage openMyList() {
        logStep("When I open My list page");
        waitForNSeconds(5);
        btnMyList.click();
        waitForNSeconds(5);
        return new MyListPage();
    }
}
