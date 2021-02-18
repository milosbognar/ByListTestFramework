package com.milosbognar.buylist.test.elements.home;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePageElement extends BasePageElement {

    @AndroidFindBy(xpath = "//*[@resource-id='com.slava.buylist:id/textView1' and @text='Buy list']")
    protected WebElement hdrBuyList;

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    protected WebElement txtListName;

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    protected WebElement btnCreateList;

    @AndroidFindBy(id = "ccom.slava.buylist:id/listView1")
    protected WebElement listBuyList;

    @AndroidFindBy(id = "com.slava.buylist:id/button1")
    protected WebElement btnMenu;

    @AndroidFindBy(xpath = "//*[@text = 'Settings']")
    protected WebElement btnSettings;

    protected String lblListNameForSpecifiedList(String listName) {
        return "//*[@resource-id = 'com.slava.buylist:id/title' and @text = '" + listName + "']";
    }

    protected String lblListDetailsForSpecifiedList(String listName) {
        return "//*[@resource-id = 'com.slava.buylist:id/title' and @text = '" + listName + "']/following-sibling::android.widget.TextView[@resource-id = 'com.slava.buylist:id/str1']";
    }

    protected String btnRemoveForSpecifiedList(String listName) {
        return "//*[@resource-id = 'com.slava.buylist:id/title' and @text = '" + listName + "']/following-sibling::android.widget.ImageView[@resource-id = 'com.slava.buylist:id/imageView1']";
    }

    protected String btnEditNameForSpecifiedList(String listName) {
        return "//*[@resource-id = 'com.slava.buylist:id/title' and @text = '" + listName + "']/following-sibling::android.widget.ImageView[@resource-id = 'com.slava.buylist:id/imageView2']";
    }

}
