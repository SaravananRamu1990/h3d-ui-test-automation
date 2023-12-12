package com.h3d.ui.base;

import com.h3d.ui.properties.PropertyParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    static Logger logger = Logger.getLogger(BaseTest.class);

    /*
     * This method is used to launch the browser based on the input
     *
     * @parameters need to send while calling this method
     */

   @BeforeTest
   @Parameters({ "browserName" })
    public void browserLaunch(String browserName) {
        try {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
//                    System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver.exe");
                    driver = new ChromeDriver(chromeOptions);
                    logger.info("Launching the " + browserName + " browser");
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    logger.info("Launching the " + browserName + " browser");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    logger.info("Launching the " + browserName + " browser");
                    break;
                default:
                    logger.error("unable to launching the browser");
                    break;
            }
            driver.get(PropertyParser.readLocators("QAURL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(Integer.parseInt(PropertyParser.readLocators("implicitWaitSec"))));
            Assert.assertEquals(driver.getCurrentUrl(), PropertyParser.readLocators("QAURL"));
        } catch (Exception exception) {
            logger.error("Unable to launch the browser " + exception);
        }
    }

    /**
     * This method is used to close the browser
     */
    @AfterTest
    public void tearDown() {
        driver.quit();
        logger.info("The browser is closed");
    }












}
