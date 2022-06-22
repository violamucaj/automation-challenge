package com.automationexercise.test.cases;

import com.automationexercise.base.grid.BaseTest;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignUpPage;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    public static final String CONFIG_KEY_URL = "url";

    @Test
    public void signUpTestCases() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        driver.get(properties.getProperty(CONFIG_KEY_URL));

        homePage.clicksignupLoginButton();
        loginPage.fillSignupForm();
        signUpPage.fillSignupForm();
        accountCreatedPage.confirmAccountNotification();
        accountCreatedPage.clickContinueButton();
        homePage.checkUsername();
    }
}

