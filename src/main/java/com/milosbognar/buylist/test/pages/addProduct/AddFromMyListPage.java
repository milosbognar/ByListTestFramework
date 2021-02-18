package com.milosbognar.buylist.test.pages.addProduct;

import com.milosbognar.buylist.test.elements.addProduct.AddFromMyListElement;
import io.qameta.allure.Step;

import static com.milosbognar.buylist.core.utils.Utilities.*;

public class AddFromMyListPage extends AddFromMyListElement {

    @Step("When I add all my items to the list")
    public AddProductPage addAllMyItemsToList() {
        logStep("When I add all my items to the list");
        btnSelectAll.click();
        btnOK.click();
        implicitlyWaitForNSeconds(3);
        return new AddProductPage();
    }
}
