package com.automationexercise.test.cases;

import com.automationexercise.base.grid.BaseTest;
import com.automationexercise.pages.LoginPage;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    public static final String CONFIG_KEY_URL = "url";

    @Test
    public void signUpTestCases() {
        LoginPage signUpCheck = new LoginPage(driver);

        driver.get(properties.getProperty(CONFIG_KEY_URL));
    }
}

