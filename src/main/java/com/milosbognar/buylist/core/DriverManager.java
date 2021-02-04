package com.milosbognar.buylist.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.milosbognar.buylist.core.utils.Utilities.waitForNSeconds;

public class DriverManager {

    public static AndroidDriver<AndroidElement> driver;

    public static boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/emulator/startEmulator.sh");
        Thread.sleep(6000);
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        File f = new File("src/");
        File fs = new File(f, (String) prop.get(appName));

        DesiredCapabilities cap = new DesiredCapabilities();
        String device = System.getProperty("deviceName");
//
//        if (device.contains("emulator")) {
//            startEmulator();
//        }

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
    }

    public static void prepareDriver() throws IOException, InterruptedException {
        //Runtime.getRuntime().exec("killall node");
        Thread.sleep(3000);
        AndroidDriver<AndroidElement> driver = capabilities("appName");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForNSeconds(5);
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        waitForNSeconds(5);
    }
}
