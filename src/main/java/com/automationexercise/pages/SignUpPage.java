package com.automationexercise.pages;

import com.automationexercise.base.grid.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseTest {
    public static final String ACCOUNT_CREATED_URL = "accountCreatedUrl";
    public static final String PASSWORD_SIGNUP = "validPasswordLogin";
    public static final String DAYS = "25";
    public static final String MONTH = "April";
    public static final String YEAR = "1992";
    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "Test";
    public static final String COMPANY_NAME = "Test";
    public static final String FIRST_ADDRESS = "Test";
    public static final String SECOND_ADDRESS = "Test";
    public static final String COUNTRY = "United States";
    public static final String STATE = "Test";
    public static final String CITY = "Test";
    public static final String ZIP_CODE = "Test";
    public static final String MOBILE_NUMBER = "00012345";

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    WebElement accountInformationTitle;

    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement mrsGender;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement mrGender;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthDropdown;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearsDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement specialOfferCheckbox;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyInput;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement primaryAddressInput;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement secondaryAddressInput;

    @FindBy(xpath = "//select[@id='country']")
    WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='state']")
    WebElement stateInput;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityInput;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipCodeInput;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createAccountButton;

    public void fillSignupForm() {
        isTextDisplayed(accountInformationTitle, "ENTER ACCOUNT INFORMATION");
        sendKeys(driver, passwordInput, properties.getProperty(PASSWORD_SIGNUP));
        selectDropdownItem(daysDropdown, DAYS);
        selectDropdownItem(monthDropdown, MONTH);
        selectDropdownItem(yearsDropdown, YEAR);
        clickOnElement(driver, newsletterCheckbox);
        clickOnElement(driver, specialOfferCheckbox);
        sendKeys(driver, firstNameInput, FIRST_NAME);
        sendKeys(driver, lastNameInput, LAST_NAME);
        sendKeys(driver, companyInput, COMPANY_NAME);
        sendKeys(driver, primaryAddressInput, FIRST_ADDRESS);
        sendKeys(driver, secondaryAddressInput, SECOND_ADDRESS);
        selectDropdownItem(countryDropdown, COUNTRY);
        sendKeys(driver, stateInput, STATE);
        sendKeys(driver, cityInput, CITY);
        sendKeys(driver, zipCodeInput, ZIP_CODE);
        sendKeys(driver, mobileNumberInput, MOBILE_NUMBER);
        clickOnElementAndAssertUrl(driver, createAccountButton, properties.getProperty(ACCOUNT_CREATED_URL));
    }
}
