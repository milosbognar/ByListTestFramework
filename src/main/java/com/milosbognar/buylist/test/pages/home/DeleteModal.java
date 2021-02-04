package com.milosbognar.buylist.test.pages.home;

import com.milosbognar.buylist.test.elements.home.DeleteModalElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static com.milosbognar.buylist.core.utils.Utilities.isElementPresent;
import static com.milosbognar.buylist.core.utils.Utilities.logStep;

public class DeleteModal extends DeleteModalElement {

    @Step("Then delete modal elements are present")
    public DeleteModal verifyDeleteModalElements() {
        logStep("Then delete modal elements are present");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isElementPresent(lblDelete))
                .describedAs("Presence of 'Delete' modal title")
                .isTrue();
        softAssertions.assertThat(isElementPresent(lblAreYouSure))
                .describedAs("Presence of 'Are you sure?' message")
                .isTrue();
        softAssertions.assertThat(isElementPresent(btnOK))
                .describedAs("Presence of 'OK' button")
                .isTrue();
        softAssertions.assertThat(isElementPresent(btnNo))
                .describedAs("Presence of 'NO' button")
                .isTrue();
        softAssertions.assertAll();
        return this;
    }

    @Step("When I click on 'OK' button")
    public HomePage clickButtonOK() {
        logStep("When I click on 'OK' button");
        btnOK.click();
        return new HomePage();
    }

    @Step("When I click on 'No' button")
    public HomePage clickButtonNo() {
        logStep("When I click on 'No' button");
        btnNo.click();
        return new HomePage();
    }
}
