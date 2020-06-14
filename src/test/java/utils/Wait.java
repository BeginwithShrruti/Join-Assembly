package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Wait {

    private static final Logger LOGGER = LogManager.getLogger(Wait.class);


    public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds)
    {
        until(driver, (d) ->
        {
            Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) LOGGER.info("Document is loading");
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition)
    {
        until(driver, waitCondition, 3L);
    }

    public static void untilWebElement(WebDriver driver, Function<WebDriver, WebElement> waitCondition)
    {
        untilWebElement(driver, waitCondition, 3L);
    }


    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try{
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
        }
    }

    private static void untilWebElement(WebDriver driver, Function<WebDriver, WebElement> waitCondition, Long timeoutInSeconds)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try{
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
        }
    }
}