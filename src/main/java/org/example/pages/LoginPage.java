package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver webDriver;

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("submit");

    public LoginPage() {
        this.webDriver = DriverManager.getDriver();
    }

    public void clickOnLogin(String user , String pass) {
        webDriver.findElement(username).sendKeys(user);
        webDriver.findElement(password).sendKeys(pass);
        webDriver.findElement(loginBtn).click();
    }

}
