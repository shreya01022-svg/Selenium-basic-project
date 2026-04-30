package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private final WebDriver webDriver;

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("submit");

    private static final Logger log =
            LoggerFactory.getLogger(LoginPage.class);

    public LoginPage() {
        this.webDriver = DriverManager.getDriver();
    }

    public void clickOnLogin(String user , String pass) {
        RemoteWebDriver remote = (RemoteWebDriver) webDriver;
        log.info("The test is running on browser:{}", remote.getCapabilities().getBrowserName());
        webDriver.findElement(username).sendKeys(user);
        webDriver.findElement(password).sendKeys(pass);
        webDriver.findElement(loginBtn).click();
    }

}
