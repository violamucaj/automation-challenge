package com.automationexercise.test.cases;

import com.automationexercise.base.grid.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    public static final String CONFIG_KEY_URL = "url";
    public static final String INVALID_EMAIL_ADDRESS = "invalid@gmail.com";
    public static final String INVALID_PASSWORD = "invalidPassword";

    @Test
    public void loginTestCases() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get(properties.getProperty(CONFIG_KEY_URL));

        homePage.clicksignupLoginButton();
        loginPage.fillLoginForm(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD);
        loginPage.checkErrorMessage();
    }
}
