package com.milosbognar.buylist.test.elements.settings;

import com.milosbognar.buylist.test.elements.BasePageElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CategoriesListElement extends BasePageElement {

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.Button[@text = 'Add new']"),
            @AndroidBy(xpath = "//android.widget.Button[@text = 'ADD NEW']")
    })
    protected WebElement btnAddNew;

    @AndroidFindBy(className = "android.widget.EditText")
    protected WebElement txtEnterName;
}
