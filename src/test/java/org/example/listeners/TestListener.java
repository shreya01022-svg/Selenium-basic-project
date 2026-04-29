package org.example.listeners;

import io.qameta.allure.Allure;
import org.example.utils.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.capture(result.getName());

        ScreenshotUtil.attachScreenshot(path);

        Allure.step("Test failed: " + result.getName());
    }
}
