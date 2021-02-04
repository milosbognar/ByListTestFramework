package com.milosbognar.buylist.test.elements;

import com.milosbognar.buylist.core.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageElement {

    protected AppiumDriver driver;

    public BasePageElement() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
