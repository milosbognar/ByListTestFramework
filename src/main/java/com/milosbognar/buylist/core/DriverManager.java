package com.milosbognar.buylist.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.milosbognar.buylist.core.PropertiesManager.getProjectProperty;
import static com.milosbognar.buylist.core.PropertiesManager.getSystemProperty;
import static com.milosbognar.buylist.core.utils.Utilities.waitForNSeconds;

public class DriverManager {

    public static AndroidDriver<AndroidElement> driver;

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/emulator/startEmulator.sh");
        Thread.sleep(6000);
    }

    public static AndroidDriver<AndroidElement> initializer() throws IOException, InterruptedException {
        Thread.sleep(3000);
        File rootDirectory = new File("src/");
        File appPath = new File(rootDirectory, getProjectProperty("appName"));
        DesiredCapabilities cap = new DesiredCapabilities();
        String device = getSystemProperty("deviceName");

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());

        String isLocalRun = getSystemProperty("isLocalRun");

        if (isLocalRun.equals("false")) {
            startEmulator();
        }

        driver = new AndroidDriver<>(new URL(getProjectProperty("hubUrl")), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForNSeconds(5);
        return driver;
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        waitForNSeconds(5);
    }
}
