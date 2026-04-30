package org.example.tests;

import org.example.driver.DriverFactory;
import org.example.driver.DriverManager;
import org.example.utils.ConfigManager;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) throws Exception {
        DriverFactory.createDriver(browser);
        DriverManager.getDriver().get(ConfigManager.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
