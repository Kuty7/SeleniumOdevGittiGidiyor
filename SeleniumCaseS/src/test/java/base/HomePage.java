package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;



public class HomePage extends BasePage{

    //private static final Logger logger = LogManager.getLogger(BasePage.class);


    //BasePage base = new BasePage();
    List<WebElement> underIcons;

    By logOutLocator = new By.ByCssSelector("a[title='Çıkış']");
    By underIconsLocator = new By.ByCssSelector("a.sc-84am1q-0.sc-1r48nyr-0.dGMkVn.sc-12t95ss-6.jfpyWy");
    By loggedIcon = new By.ByCssSelector("div.gekhq4-8.iHquZr");
    By loginHover = new By.ByCssSelector("div.gekhq4-4.egoSnI");
    By loginButton = new By.ByCssSelector("a.qjixn8-0.sc-1bydi5r-0.lghPw");
    By searchBox = new By.ByCssSelector("input.sc-4995aq-0.sc-14oyvky-0.gHqOYK");
    By searchButton = new By.ByCssSelector("button.qjixn8-0.sc-1bydi5r-0.gaMakD");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllSearchedItemsByLocator(By by) {
        return findAll(by);
    }

    public void pressLogIn() throws InterruptedException {
        hoverElement(loginHover);
        waitLoad(loginButton);
        //TimeUnit.MILLISECONDS.sleep(500);
        clickElement(loginButton);
        logger.info("Pressed Login.");
    }

    public void searchBoxInsertAndClick(String searchItemName){
        fillTextBox(searchBox, searchItemName);
        clickElement(searchButton);
        logger.info("(" + searchItemName + ") searched.");
    }

    public void logOut(){
        hoverElement(loggedIcon);
        waitLoad(logOutLocator);
        clickElement(logOutLocator);
        logger.info("Logout method executed successfully!");
    }


}
