package com.milosbognar.buylist.test.pages.settings;

import com.milosbognar.buylist.test.elements.settings.SortListModalElement;
import io.qameta.allure.Step;

import static com.milosbognar.buylist.core.utils.Utilities.*;

public class SortListModal extends SortListModalElement {

    @Step("Then I choose alphabet option")
    public SettingsPage chooseByAlphabetOption() {
        logStep("Then I choose alphabet option");
        cbByAlphabet.click();
        implicitlyWaitForNSeconds(5);
        return new SettingsPage();
    }
}
