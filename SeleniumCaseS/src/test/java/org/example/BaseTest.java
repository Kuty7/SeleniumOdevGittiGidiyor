package org.example;

import static org.junit.Assert.assertTrue;

import base.BasePage;
import base.HomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */


public class BaseTest
{

    protected static ChromeDriver driver;
    //protected WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.get("https://www.gittigidiyor.com/");

        System.out.println(driver.getCurrentUrl());
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
      //  TimeUnit.SECONDS.sleep(2);
        driver.close();
        driver.quit();
    }

}
