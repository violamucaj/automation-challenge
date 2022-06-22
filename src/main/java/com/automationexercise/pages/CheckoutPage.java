package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    public static final String PAYMENT_URL = "paymentUrl";

    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Place Order')]")
    WebElement placeOrderButton;

    public void clickOnPlaceOrderButton(){
        clickOnElementAndAssertUrl(driver, placeOrderButton, properties.getProperty(PAYMENT_URL));
    }
}
