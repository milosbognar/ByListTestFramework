package com.milosbognar.buylist.test.elements.addProduct;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddProductElement extends BasePageElement {

    @AndroidFindBy(xpath = "//*[@text = 'OK']")
    protected WebElement btnOK;

    @AndroidFindBy(xpath = "//*[@text = 'Add product...']")
    protected WebElement txtItemName;

    @AndroidFindBy(xpath = "//*[@text = 'Price']")
    protected WebElement txtPrice;

    @AndroidFindBy(xpath = "//*[@text = 'Amount']")
    protected WebElement txtAmount;

    @AndroidFindBy(id = "com.slava.buylist:id/spinner1")
    protected WebElement spinnerMeasureUnit;

    @AndroidFindBy(xpath = "//*[@text = 'Comment']")
    protected WebElement txtComment;

    @AndroidFindBy(id = "com.slava.buylist:id/spinner2")
    protected WebElement spinnerCategory;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    protected WebElement btnAddItem;

    @AndroidFindBy(id = "com.slava.buylist:id/textView2")
    protected WebElement lblTotalPrice;

    @AndroidFindBy(id = "com.slava.buylist:id/button1")
    protected WebElement btnMenu;

    @AndroidFindBy(xpath = "//*[@text = 'Settings']")
    protected WebElement btnSettings;

    @AndroidFindBy(xpath = "//*[@text = 'Remind']")
    protected WebElement btnRemind;

    @AndroidFindBy(xpath = "//*[@text = 'Add from my listtttt']")
    protected WebElement btnAddFromMyList;

    @AndroidFindBy(id = "com.slava.buylist:id/str1")
    protected WebElement lblComment;

    @AndroidFindBy(id = "com.slava.buylist:id/TextView01")
    protected WebElement lblUnit;

    @AndroidFindBy(xpath = "//*[@resource-id='com.slava.buylist:id/title']/following-sibling::android.widget.TextView[@resource-id='com.slava.buylist:id/textView1']")
    protected WebElement lblPrice;

    @AndroidFindBy(xpath = "//*[@resource-id='com.slava.buylist:id/title']")
    protected List<WebElement> listItemNames;

    protected String lblPrice(String listName) {
        return "//*[@resource-id = 'com.slava.buylist:id/imageView1' and not(contains(@text,'" + listName + "'))]";
    }
}
