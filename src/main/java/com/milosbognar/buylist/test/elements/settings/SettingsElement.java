package com.milosbognar.buylist.test.elements.settings;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SettingsElement extends BasePageElement {

    @AndroidFindBy(xpath = "//*[@text = 'Sort list']")
    protected WebElement btnSortList;

    @AndroidFindBy(xpath = "//*[@text = 'Currency']")
    protected WebElement btnCurrency;

    @AndroidFindBy(xpath = "//*[@text = 'Own currency']")
    protected WebElement btnOwnCurrency;

    @AndroidFindBy(xpath = "//*[@text = 'Font size']")
    protected WebElement btnFontSize;

    @AndroidFindBy(xpath = "//*[@text = 'Orientation']")
    protected WebElement btnOrientation;

    @AndroidFindBy(xpath = "//*[@text = 'Units']")
    protected WebElement cbUnits;

    @AndroidFindBy(xpath = "//*[@text = 'Comment']")
    protected WebElement cbComment;

    @AndroidFindBy(xpath = "//*[@text = 'Price']")
    protected WebElement cbPrice;

    @AndroidFindBy(xpath = "//*[@text = 'Categories List']")
    protected WebElement btnCategoriesList;

    @AndroidFindBy(xpath = "//*[@text = 'My List']")
    protected WebElement btnMyList;
}
