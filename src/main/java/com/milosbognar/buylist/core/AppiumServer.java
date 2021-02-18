package com.milosbognar.buylist.core;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {

    public static AppiumDriverLocalService service;

    public static AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static void stopServer() {
        service.stop();
    }

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
}