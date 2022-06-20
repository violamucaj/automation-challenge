package com.automationexercise.base.grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    public static Logger log;
    protected Properties properties = new Properties();
    public static final String GRID_SETTING = "grid";
    public static final String CONFIG_PROPERTIES_PATH = "src/main/resources/config.properties";
    public static final String TEXTSOURCE_PROPERTIES_PATH = "src/main/resources/TextSource.properties";
    public static final String CHROME_BROWSER = "chrome";
    public static final String WEB_DIRECTORY = "browser";
    public static final String CONFIG_SETTING = "setting";
    public static final String NODE_URL = "nodeURL";
    public static final String BUTTON_STATE_DISABLED = "disabled";
    public static final String BUTTON_STATE_ENABLED = "enabled";


    public BaseTest() {

        // Create Properties class object to access properties file
        FileInputStream configFileInput = null;
        FileInputStream textFileInput = null;
        try {
            configFileInput = new FileInputStream(new File(CONFIG_PROPERTIES_PATH));
            textFileInput = new FileInputStream(new File(TEXTSOURCE_PROPERTIES_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Load properties file
        try {
            properties.load(configFileInput);
            properties.load(textFileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({WEB_DIRECTORY, CONFIG_SETTING})
    protected void setUp(@Optional(CHROME_BROWSER) String browser, @Optional(GRID_SETTING) String setting, ITestContext ctx) throws MalformedURLException {
        // Create Driver
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        if (setting.equals(GRID_SETTING)) {
            driver = factory.createGridDriver(properties.getProperty(NODE_URL));
        } else {
            driver = factory.createDriver();
        }

        // Maximize browser window
        driver.manage().window().maximize();

        // Set up test name and Logger
        setCurrentThreadName();
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        // Closing driver
        log.info("[Closing driver]");
        driver.quit();
    }

    // Sets thread name which includes thread id
    private void setCurrentThreadName() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        String threadId = String.valueOf(thread.getId());
        if (!threadName.contains(threadId)) {
            thread.setName(threadName + " " + threadId);
        }
    }
}
