package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseTest {
    public static final String CART_URL = "cartUrl";
    public static final String GREEN_TOP_SEARCH_URL = "greenTopSearchResult";
    public static final String GREEN_TOP_TEXT = "Fancy Green Top";


    public ProductsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchProductInput;

    @FindBy(xpath = "//h2[contains(text(),'Rs. 1000')]")
    WebElement rsPrice;

    @FindBy(xpath = "//a[contains(@class, 'add-to-cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartButton;

    @FindBy(xpath = "//button[contains(text(), 'Continue Shopping')]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement submitSearchButton;

    @FindBy(xpath = "//div[@class='product-overlay']")
    WebElement productOverlay;

    public void searchProducts(String text, String url){
        sendKeys(driver, searchProductInput, text);
        clickOnElementAndAssertUrl(driver, submitSearchButton, url);
    }

    public void confirmRSPrice(){
        isTextDisplayed(rsPrice, "Rs. 1000");
    }

    public void addProductsCart() throws InterruptedException {
        clickOnElement(driver, addToCartButton);
        Thread.sleep(2000);
        clickOnElement(driver, continueShoppingButton);
        clearData(searchProductInput);
        searchProducts(GREEN_TOP_TEXT, properties.getProperty(GREEN_TOP_SEARCH_URL));
        waitForElement(driver, addToCartButton);
        clickOnElement(driver, addToCartButton);
        clickOnElementAndAssertUrl(driver, viewCartButton, properties.getProperty(CART_URL));
    }
}
