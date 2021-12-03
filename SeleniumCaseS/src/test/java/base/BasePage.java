package base;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends BaseTest {

    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    protected WebDriverWait wait;
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String favdImgHolder;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public void clickElement(By by){
        findElement(by).click();
    }

    public void clickWebElement(WebElement element){
        element.click();
    }

    public void hoverElement(By by){
        Actions action;
        action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void hoverUsingElement(WebElement element){
        Actions action;
        action = new Actions(driver);
        action.moveToElement(element);
    }

    public void fillTextBox(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void waitLoad(By by){
        WebDriverWait wait01 = new WebDriverWait(driver, 10);
        wait01.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element){
        return element.isEnabled();
    }

    public void verticalScrollDown(int scrollLength){
        String scrollString = ("scroll(0," + String.valueOf(scrollLength) + ")");
        ((JavascriptExecutor)driver).executeScript(scrollString);
        logger.info(String.valueOf(scrollLength) + " unit scrolled.");
        //"scroll(0,10000)"
    }

    public List<WebElement> findAll(By by){
        return driver.findElements(by);
    }

    public void selectDD(By by, String seekingTest){
        Select select = new Select(findElement(by));
        select.selectByVisibleText(seekingTest);
    }

    public String getProductAttribute(WebElement element, String attributeName){
        String attributeHolder = element.getAttribute(attributeName);
        return attributeHolder;
    }

    public void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com");
    }

}
