package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseTest {

    public static final String CARD_NUMBER ="cardNumber";
    public static final String CARD_NAME = "cardName";
    public static final String CVC_NUMBER = "cvc";
    public static final String EXPIRY_MONTH = "11";
    public static final String EXPIRY_YEAR = "2077";

    public PaymentPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvcInput;

    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement expiryMonthInput;

    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement expiryYearInput;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement payAndConfirmButton;

    public void fillPaymentForm() throws InterruptedException {
        sendKeys(driver, nameOnCardInput, properties.getProperty(CARD_NAME));
        sendKeys(driver, cardNumberInput, properties.getProperty(CARD_NUMBER));
        sendKeys(driver, cvcInput, properties.getProperty(CVC_NUMBER));
        sendKeys(driver, expiryMonthInput, EXPIRY_MONTH);
        sendKeys(driver, expiryYearInput, EXPIRY_YEAR);
        clickOnElement(driver, payAndConfirmButton);
        Thread.sleep(3000);
    }
}
