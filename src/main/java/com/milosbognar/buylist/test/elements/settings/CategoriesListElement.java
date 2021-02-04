package com.milosbognar.buylist.test.elements.settings;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CategoriesListElement extends BasePageElement {

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Add new']")
    protected WebElement btnAddNew;

    @AndroidFindBy(className = "android.widget.EditText")
    protected WebElement txtEnterName;

    @AndroidFindBy(id = "android:id/button1")
    protected WebElement btnOK;

    @AndroidFindBy(xpath = "//*[@text = 'No']")
    protected WebElement btnNo;
}
