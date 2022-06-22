package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

import java.util.Random;

public class LoginPage extends BaseTest {
    WebDriver driver;

    public static final String SIGN_UP_TEXT = "New User Signup!";
    public static final String LOGIN_TEXT = "Login to your account";
    public static final String ERROR_MESSAGE = "Your email or password is incorrect!";
    public static final String SIGN_UP_URL = "signupUrl";
    public static final String CONFIG_KEY_URL = "url";

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    WebElement newUserSignupTitle;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInputSignup;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailInputSignup;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    WebElement signupButton;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    WebElement loginAccountTitle;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailInputLogin;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passwordInputLogin;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]")
    WebElement errorMessageLogin;

    public String getRandomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999999);
        return Integer.toString(number);
    }

    String randomChar = getRandomNumber() + getRandomNumber();
    String email = "qateam+" + randomChar + "@gmail.com";

    public void fillSignupForm(){
        isTextDisplayed(newUserSignupTitle, SIGN_UP_TEXT);
        sendKeys(driver, emailInputSignup, email);
        sendKeys(driver, nameInputSignup, "test");
        clickOnElementAndAssertUrl(driver, signupButton, properties.getProperty(SIGN_UP_URL) );
    }

    public void fillLoginForm(String email, String password) {
        isTextDisplayed(loginAccountTitle, LOGIN_TEXT);
        sendKeys(driver, emailInputLogin, email);
        sendKeys(driver, passwordInputLogin, password);
        if (email == "invalid@gmail.com") {
            clickOnElement(driver, loginButton);
        } else {
            clickOnElementAndAssertUrl(driver, loginButton, properties.getProperty(CONFIG_KEY_URL));
        }
    }

    public void checkErrorMessage(){
        waitForElement(driver, errorMessageLogin);
        isTextDisplayed(errorMessageLogin, ERROR_MESSAGE);
    }
}
