package org.example.tests;

import org.example.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(LoginTest.class);
    @Test
    public void testLogin() {
        log.info("Starting login test");
        LoginPage page = new LoginPage();
        page.clickOnLogin("student", "Password123");
        Assert.assertTrue(true);
    }

    @Test
    public void fakeTest() {
        log.info("Starting fake test");
        Assert.assertTrue(false);
    }

}
