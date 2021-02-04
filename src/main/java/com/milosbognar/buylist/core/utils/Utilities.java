package com.milosbognar.buylist.core.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import static com.milosbognar.buylist.core.DriverManager.getDriver;
import static java.lang.String.format;

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

    public static void logStep(String report, Object... arguments) {
        System.out.println("Step: " + format(report, arguments));
    }
}
