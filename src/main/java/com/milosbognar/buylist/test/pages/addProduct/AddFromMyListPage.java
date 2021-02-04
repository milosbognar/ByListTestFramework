package com.milosbognar.buylist.test.pages.addProduct;

import com.milosbognar.buylist.test.elements.addProduct.AddFromMyListElement;

import static com.milosbognar.buylist.core.utils.Utilities.logStep;
import static com.milosbognar.buylist.core.utils.Utilities.waitForNSeconds;

public class AddFromMyListPage extends AddFromMyListElement {

    public AddProductPage addAllMyItemsToList() {
        logStep("Whein I add all my items to the list");
        btnSelectAll.click();
        btnOk.click();
        waitForNSeconds(3);
        return new AddProductPage();
    }
}
