package com.milosbognar.buylist.core.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static com.milosbognar.buylist.core.DriverManager.getDriver;
import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Utilities {

    @AndroidFindBy(xpath = "//*[@resource-id='com.slava.buylist:id/textView1' and @text='Buy list']")
    protected WebElement hdrHomePage;

    private static AndroidDriver<AndroidElement> driver;

    public Utilities() {
        driver = getDriver();
    }

    public static void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    public static void hideKeyboard() {
        waitForNSeconds(1);
        if (driver.isKeyboardShown()) driver.hideKeyboard();
        waitForNSeconds(1);
    }

    public static void goBack() {
        waitForNSeconds(1);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        waitForNSeconds(1);
    }

    public static void waitForNSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void clearTextField(WebElement element) {
        try {
            waitForNSeconds(1);
            element.clear();
            waitForNSeconds(1);
        } catch (Exception e) {
        }
    }

    public static void enterText(WebElement element, String text) {
        try {
            waitForNSeconds(1);
            element.sendKeys(text);
            waitForNSeconds(1);
        } catch (Exception e) {
        }
    }

    public static String getElementText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement getElementByText(String text) {
        return driver.findElementByXPath("//*[@text='" + text + "']");
    }

    public static WebElement getElementByXPath(String xpath) {
        try {
            return driver.findElementByXPath(xpath);
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement findElementByTextUsingScroll(String text) {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void closeApp() {
        driver.closeApp();
        waitForNSeconds(5);
    }

    public static void openApp() {
        driver.launchApp();
        waitForNSeconds(5);
    }

    public static void reopenApp() {
        waitForNSeconds(5);
        driver.resetApp();
        waitForNSeconds(5);
    }

    public static void implicitlyWaitForNSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);
    }

    public static void explicitlyWaitForWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void logStep(String report, Object... arguments) {
        System.out.println("Step: " + format(report, arguments));
    }
}
