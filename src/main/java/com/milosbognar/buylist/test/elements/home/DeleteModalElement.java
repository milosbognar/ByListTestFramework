package com.milosbognar.buylist.test.elements.home;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DeleteModalElement extends BasePageElement {

    @AndroidFindBy(xpath = "//*[@text = 'Delete']")
    protected WebElement lblDelete;

    @AndroidFindBy(xpath = "//*[@text = 'Are you sure?']")
    protected WebElement lblAreYouSure;
}
