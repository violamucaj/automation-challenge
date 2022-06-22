package com.automationexercise.test.cases;

import com.automationexercise.base.grid.BaseTest;
import com.automationexercise.pages.*;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    public static final String CONFIG_KEY_URL = "url";
    public static final String GREEN_T_SHIRT_SEARCH_RESULT = "greendetailTShirtSearchResult";
    public static final String GREEN_T_SHIRT = "Green Side Placket Detail T-Shirt";
    public static final String VALID_EMAIL_ADDRESS = "validEmailLogin";
    public static final String VALID_PASSWORD = "validPasswordLogin";

    @Test
    public void checkoutTestCases() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        PaymentConfirmationPage paymentConfirmationPage = new PaymentConfirmationPage(driver);

        driver.get(properties.getProperty(CONFIG_KEY_URL));

        homePage.clicksignupLoginButton();
        loginPage.fillLoginForm(properties.getProperty(VALID_EMAIL_ADDRESS), properties.getProperty(VALID_PASSWORD));
        homePage.clickProductsButton();
        productsPage.searchProducts(GREEN_T_SHIRT, properties.getProperty(GREEN_T_SHIRT_SEARCH_RESULT));
        productsPage.confirmRSPrice();
        productsPage.addProductsCart();
        viewCartPage.confirmProductsAndCheckout();
        checkoutPage.clickOnPlaceOrderButton();
        paymentPage.fillPaymentForm();
        paymentConfirmationPage.confirmOrder();
    }
}
