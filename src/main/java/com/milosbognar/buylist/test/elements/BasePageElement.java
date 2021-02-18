package com.milosbognar.buylist.test.elements;

import com.milosbognar.buylist.core.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.milosbognar.buylist.core.utils.Utilities.logStep;

public abstract class BasePageElement {

    protected AppiumDriver driver;

    public BasePageElement() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text = 'Ok']"),
            @AndroidBy(xpath = "//*[@text = 'OK']"),
            @AndroidBy(id = "android:id/button1"),
            @AndroidBy(xpath = "//android.widget.Button[@text = 'Ok']")
    })
    protected WebElement btnOK;


    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@text = 'No']"),
            @AndroidBy(xpath = "//*[@text = 'NO']")
    })
    protected WebElement btnNo;

    @Step("When I close popup")
    public void closePopup() {
        logStep("Close popup");
        btnOK.click();
    }
}
