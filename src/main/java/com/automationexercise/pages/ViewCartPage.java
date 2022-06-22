package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage extends BaseTest {

    public static final String CHECKOUT_URL = "checkoutUrl";
    public static final String GREEN_T_SHIRT_TEXT ="Green Side Placket Detail T-Shirt";
    public static final String GREEN_TOP_TEXT = "Fancy Green Top";

    public ViewCartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Green Side Placket Detail T-Shirt')]")
    WebElement greenSideTShirtText;

    @FindBy(xpath = "//a[contains(text(),'Fancy Green Top')]")
    WebElement fancyGreenTopText;

    @FindBy(xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    WebElement proceedToCheckoutButton;

    public void confirmProductsAndCheckout(){
        isTextDisplayed(greenSideTShirtText, GREEN_T_SHIRT_TEXT);
        isTextDisplayed(fancyGreenTopText, GREEN_TOP_TEXT);
        clickOnElementAndAssertUrl(driver, proceedToCheckoutButton, properties.getProperty(CHECKOUT_URL));
    }
}
