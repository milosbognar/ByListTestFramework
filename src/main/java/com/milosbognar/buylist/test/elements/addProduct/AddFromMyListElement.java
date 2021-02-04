package com.milosbognar.buylist.test.elements.addProduct;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AddFromMyListElement extends BasePageElement {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Select all']")
    protected WebElement btnSelectAll;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Ok']")
    protected WebElement btnOk;
}
