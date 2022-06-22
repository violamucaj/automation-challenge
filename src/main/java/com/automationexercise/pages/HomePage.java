package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public static final String SIGNUP_LOGIN_URL = "signupLoginUrl";
    public static final String PRODUCTS_URL = "productsUrl";

    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement signupLoginButton;

    @FindBy(xpath = "//b[contains(text(),'test')]")
    WebElement usernameText;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsButton;

    public void clicksignupLoginButton(){
        clickOnElementAndAssertUrl(driver, signupLoginButton, properties.getProperty(SIGNUP_LOGIN_URL));
    }

    public void checkUsername(){
        isTextDisplayed(usernameText, "test");
    }

    public void clickProductsButton(){
        clickOnElementAndAssertUrl(driver,productsButton, properties.getProperty(PRODUCTS_URL) );
    }
}
