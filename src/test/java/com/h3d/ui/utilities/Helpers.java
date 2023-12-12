package com.h3d.ui.utilities;


import com.h3d.ui.base.BaseTest;
import com.h3d.ui.properties.PropertyParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Helpers extends BaseTest {


//    static WebDriver driver ;
    static WebDriverWait wait;
    public static Logger logger = Logger.getLogger(Helpers.class);

    public static void launchBrowser(String browserName, String url) {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().to(url);

        } else if (browserName.equalsIgnoreCase("ie")) {

//            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);

        } else if (browserName.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);

        } else if (browserName.equalsIgnoreCase("opera")) {

            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);

        } else if (browserName.equalsIgnoreCase("safari")) {

            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);

        } else {
            System.out.println("Enter correct browser name");
        }

    }

    public static void click(By locateElement) {
        try {
            Actions action = new Actions(driver);
            isDisplayed(locateElement);
          //  elementToBeClickable(locateElement);
            action.moveToElement(driver.findElement(locateElement)).click().build().perform();
        } catch (Exception exception) {
            logger.error("unable to click " + locateElement + exception);
        }
    }

    public void selectByValue(By locator, String value) {
        try {
            Select select = new Select(driver.findElement(locator));
            select.selectByValue(value);
        } catch (Exception exception) {
            logger.error("Unable to select by value" + value + " " + exception);
        }
    }

    public static void selectByText(By locator, String text) {
        try {
            Select select = new Select(driver.findElement(locator));
            select.selectByVisibleText(text);
        } catch (Exception exception) {
            logger.error("unable to select by text " + text + " :-" + exception);
        }
    }

    public void selectByIndex(By locator, int index) {
        try {
            Select select = new Select(driver.findElement(locator));
            select.selectByIndex(index);
        } catch (Exception exception) {
            logger.error("unable to select by index " + locator + " " + exception);
        }
    }

    public static void moveTo(By destination) {
        try {
            Actions action = new Actions(driver);
            isDisplayed(destination);
            action.moveToElement(driver.findElement(destination)).build().perform();
        } catch (Exception exception) {
            logger.error("Unable to move to the element " + destination + " " + exception);
        }
    }

    /**
     * This method is used to scroll the element using javascript executor
     *
     * @param destination : - This is used to scroll the element by visibility
     */
    public static void scrollByVisibilityofElement(By destination) {
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", destination);
        } catch (Exception exception) {
            logger.error("Unable to scroll by visibility " + destination + " " + exception);
        }
    }

    /**
     * This method is used to scroll down the element
     */
    public static void scrollDown() {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            logger.info("The element is scroll down");
        } catch (Exception exception) {
            logger.error("Unable to scroll down the element" + exception);
        }

    }

    /**
     * This method is used to key down
     */
    public static void arrowDown() {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
            action.sendKeys(Keys.ENTER).build().perform();
        } catch (Exception exception) {
            logger.error("Unable to arrow down the element" + exception);
        }
    }

    /**
     * This method is used to scroll up the element
     */
    public static void scrollUp() {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_UP).build().perform();
        } catch (Exception exception) {
            logger.error("Unable to scroll up the element" + exception);
        }

    }

    /**
     * This method is used to taking a screenshot in run time
     *
     * @param fileName : file name of the screenshot
     * @return
     */
    public static String screenShot(String fileName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + fileName + "_" + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (Exception exception) {
            logger.error("Unable to take the screenshot" + exception);
        }
        return destination;
    }

    /**
     * This method is used for enter the text
     *
     * @param locator              : The locator is used to read text
     * @param expectedValueToEnter : Expected value to enter in the textbox
     */
//    public static void enterText(By locator, String expectedValueToEnter) {
//        try {
//            if (isDisplayed(locator)) {
//                driver.findElement(locator).clear();
//                driver.findElement(locator).sendKeys(expectedValueToEnter);
//                logger.info("The " + expectedValueToEnter + " enterted into the textBox");
//            } else {
//                logger.error("unable to enter the" + expectedValueToEnter + " into the textBox");
//            }
//        } catch (Exception exception) {
//            logger.error("unable to Enter :" + expectedValueToEnter + exception);
//        }
//    }
    public static void enterText(By locator, String text) {
        try {
            driver.findElement(locator).sendKeys(text);
            logger.info("Text is entered");
        } catch (Exception e) {
            logger.error("Text not get entered");

        }
    }

    /**
     * This method is used for read the text in page.
     *
     * @param locator :- This is used to read the text in page.
     * @return
     */
    public static String readText(By locator) {

        String readText = null;
        try {
            if (isDisplayed(locator)) {
                readText = driver.findElement(locator).getText();
                logger.info(readText + " text is visible");
            }
        } catch (Exception exception) {
            logger.error("unable to read the text" + exception);
        }
        return readText;
    }

    /**
     * The method is used to verify is displayed or not
     *
     * @param locator : - This is locator is used to verify the element is displayed
     *                or not
     * @return
     */
    public static boolean isDisplayed(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
            logger.info("The  element is Present ");
            return true;
        } catch (Exception exception) {
            logger.error("The " + locator + " element is NOT Present :" + exception);
            return false;
        }

    }

    /**
     * This method is used to verify the element is selected or not
     *
     * @param locator This is locator is used to verify the element is selected or
     *                not
     * @return
     */
    public static boolean isSelected(By locator) {
        try {
            driver.findElement(locator).isSelected();
            logger.info("The  element is Present ");
            return true;
        } catch (Exception exception) {
            logger.error("The " + locator + " element is NOT Present :" + exception);
            return false;
        }

    }

    /**
     * This method is used to verify the element is enabled or not
     *
     * @param locator :- This locator is used to verify the element is enabled or
     *                not
     * @return
     */
    public static boolean isEnabled(By locator) {
        try {
            driver.findElement(locator).isEnabled();
            logger.info("The button is Enabled");
            return true;
        } catch (Exception exception) {
            logger.error("The " + locator + " button is NOT Enabled" + exception);
            return false;
        }

    }

    /**
     * This method is used for select the value using dropdown
     *
     * @param locator :- This locator is used to select the index
     * @param value    :- The expected value to enter into select.
     */
    public static void selectByIndex(By locator, String value) {
        try {

            List<WebElement> drop = driver.findElements(locator);
            for (int index = 0; index < drop.size(); index++) {
                String name = drop.get(index).getText();
                if (name.contains(value)) {
                    drop.get(index).click();
                    break;
                }
            }
        } catch (Exception exception) {
            logger.error("unable select the value by index " + value + " " + exception);
        }
    }

    /**
     * Explicit Wait
     *
     * @return :-
     */
    public static WebDriverWait exclipitWait() {
        return wait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(PropertyParser.readLocators("explicitwaitSec"))));
    }

    /**
     * This method is used to elementToBeClickable  using explicit wait
     *
     * @param locator :- This locator is used to click the element using explicit wait
     * @return
     */
    public static boolean elementToBeClickable(By locator) {
        try {
            exclipitWait().until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception exception) {
            logger.error("Unable to clickable the element :" + exception);
            return false;
        }
    }

    /**
     * This method is used to elementToBeSelected  using explicit wait
     *
     * @param locator :- This locator is used to select the element using explicit wait
     * @return
     */
    public static boolean elementToBeSelected(By locator) {
        try {
            exclipitWait().until(ExpectedConditions.elementToBeSelected(locator));
            return true;
        } catch (Exception exception) {
            logger.error("Unable to select the element" + exception);
            return false;
        }
    }


    /**
     * This method is used to presenceOfElementLocated using explicit wait
     *
     * @param locator :- This locator is used to select the element using explicit wait
     * @return
     */
    public static boolean presenceOfElementLocated(By locator) {
        try {
            exclipitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception exception) {
            logger.error("Element is not present " + exception);
            return false;
        }
    }

}




