package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URL;

public class DriverFactory {

    public static void initDriver(String browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver(options);
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "safari" -> new SafariDriver();
            default -> throw new RuntimeException("Invalid browser: " + browser);
        };

        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    public static void createDriver(String browser) throws Exception {

        WebDriver driver;
        URL gridUrl = new URL("http://localhost:4444");

        driver = switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                yield new RemoteWebDriver(gridUrl, chromeOptions);
            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                yield new RemoteWebDriver(gridUrl, firefoxOptions);
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                yield new RemoteWebDriver(gridUrl, edgeOptions);
            }
            case "safari" -> {
                SafariOptions safariOptions = new SafariOptions();
                yield new RemoteWebDriver(gridUrl, safariOptions);
            }
            default -> throw new RuntimeException("Unsupported browser: " + browser);
        };
        DriverManager.setDriver(driver);

    }
}
