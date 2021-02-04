package com.milosbognar.buylist.test.pages.addProduct;

import com.milosbognar.buylist.test.pages.settings.SettingsPage;
import io.qameta.allure.Step;

import static com.milosbognar.buylist.core.utils.Utilities.*;

public class MyListPage extends AddProductPage {

    @Step("When I go back to the Settings page")
    public SettingsPage backToSettingsPage() {
        logStep("When I go back to the Settings page");
        hideKeyboard();
        goBack();
        return new SettingsPage();
    }
}
