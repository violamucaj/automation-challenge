package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentConfirmationPage extends BaseTest {

    public static final String ORDER_PLACED_TEXT = "ORDER PLACED!";
    public static final String CONGRATULATION_MESSAGE = "Congratulations! Your order has been confirmed!";

    public PaymentConfirmationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Order Placed!')]")
    WebElement orderPlacedText;

    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    WebElement congratulationsMessage;

    public void confirmOrder(){
        isTextDisplayed(orderPlacedText, ORDER_PLACED_TEXT);
        isTextDisplayed(congratulationsMessage, CONGRATULATION_MESSAGE);
    }
}
