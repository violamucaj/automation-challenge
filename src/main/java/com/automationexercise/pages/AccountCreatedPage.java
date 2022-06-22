package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BaseTest {
    public static final String CONFIG_KEY_URL = "url";

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    WebElement accountCreatedTitle;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    public void confirmAccountNotification(){
        isTextDisplayed(accountCreatedTitle, "ACCOUNT CREATED!");
    }

    public void clickContinueButton(){
        clickOnElementAndAssertUrl(driver, continueButton, properties.getProperty(CONFIG_KEY_URL));
    }
}
