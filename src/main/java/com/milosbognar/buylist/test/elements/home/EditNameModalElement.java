package com.milosbognar.buylist.test.elements.home;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EditNameModalElement extends BasePageElement {

    //@AndroidFindBy(className = "android.widget.EditText")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    protected WebElement txtEnterName;

    @AndroidFindBy(id = "android:id/button1")
    protected WebElement btnOK;

    @AndroidFindBy(xpath = "//*[@text = 'No']")
    protected WebElement btnNo;
}
