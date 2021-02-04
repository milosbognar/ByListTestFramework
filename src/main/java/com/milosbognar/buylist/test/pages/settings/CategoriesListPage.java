package com.milosbognar.buylist.test.pages.settings;

import com.milosbognar.buylist.test.elements.settings.CategoriesListElement;
import io.qameta.allure.Step;

import static com.milosbognar.buylist.core.utils.Utilities.*;

public class CategoriesListPage extends CategoriesListElement {

    @Step("When I create a new category")
    public CategoriesListPage addNewCategory(String categoryName) {
        logStep("When I create category [%s]", categoryName);
        btnAddNew.click();
        enterText(txtEnterName, categoryName);
        btnOK.click();
        return this;
    }

    @Step("Then I verify that new category is created")
    public boolean isNewCategoryCreated(String categoryName) {
        logStep("Then I verift that [%s] category is created", categoryName);
        return findElementByTextUsingScroll(categoryName) != null;
    }
}
