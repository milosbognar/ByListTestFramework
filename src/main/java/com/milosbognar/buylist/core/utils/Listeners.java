package com.milosbognar.buylist.core.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static com.milosbognar.buylist.core.utils.Utilities.*;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            screenshot();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            screenshot();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        try {
            screenshot();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        try {
            screenshot();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
