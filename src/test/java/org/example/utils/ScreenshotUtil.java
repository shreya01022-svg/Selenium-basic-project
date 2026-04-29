package org.example.utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.example.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String capture(String testName) {

        File src = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String path = "reports/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        File dest = new File(path);

        try {
            FileUtils.forceMkdirParent(dest); // ensures folder exists
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException("Screenshot failed", e);
        }

        return path;
    }

    public static void attachScreenshot(String path) {
        try {
            InputStream is = Files.newInputStream(Paths.get(path));
            Allure.addAttachment("Screenshot", "image/png", is, ".png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
