package com.milosbognar.buylist.test.pages.home;

import com.milosbognar.buylist.test.elements.home.EditNameModalElement;
import io.qameta.allure.Step;

import static com.milosbognar.buylist.core.utils.Utilities.*;

public class EditNameModal extends EditNameModalElement {

    @Step("When I change list name")
    public EditNameModal chanageListName(String listName) {
        logStep("When I change list name to [%s]", listName);
        clearTextField(txtEnterName);
        enterText(txtEnterName, listName);
        return this;
    }

    @Step("When I click on 'OK' button")
    public HomePage clickButtonOK() {
        logStep("When I click on 'OK' button");
        btnOK.click();
        waitForNSeconds(5);
        return new HomePage();
    }

    @Step("When I click on 'No' button")
    public HomePage clickButtonNo() {
        logStep("When I click on 'No' button");
        btnNo.click();
        waitForNSeconds(5);
        return new HomePage();
    }
}
