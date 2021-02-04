package com.milosbognar.buylist.test.elements.settings;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SortListModalElement extends BasePageElement {

    @AndroidFindBy(xpath = "//*[@text = 'By alphabet']")
    protected WebElement cbByAlphabet;
}
