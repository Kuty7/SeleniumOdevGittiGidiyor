package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage{

    By addToCartButton = new By.ById("add-to-basket");
    By goToCartButton = new By.ByCssSelector("a.gg-ui-btn-default.padding-none");
    By cartSymbol = new By.ByCssSelector("div.basket-container.robot-header-iconContainer-cart");
    By itemInCart = new By.ByCssSelector("div.sc-1nx8ums-0.kJIJzP");
    By nameComparatorLocator = new By.ById("sp-title");

    JavascriptExecutor executor = (JavascriptExecutor)driver;

    String expectedBagNameText = "Avon Scarlett Taş Rengi Çanta";

    /*String actualBagNameText = findElement(nameComparatorLocator).getAttribute("alt");

    public void isTrueItemAdded(){
        Assert.assertEquals(expectedBagNameText, actualBagNameText);
    }*/

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void pressAddToCartButton(){
        clickElement(addToCartButton);
    }

    public void pressGoToCartButton(){
        clickElement(goToCartButton);
    }

    public void addItemToCartAndGoToCart() throws InterruptedException {
        //hoverElement(addToCartButton);
        clickElement(addToCartButton);
        //hoverElement(cartSymbol);
        TimeUnit.MILLISECONDS.sleep(500);
        //waitLoad(goToCartButton);
        //waitLoad(itemInCart);
        //hoverElement(goToCartButton);
        //clickElement(goToCartButton);
        try{
            clickElement(goToCartButton);
        }catch (Exception e){
            executor.executeScript("arguments[0].click();", findElement(goToCartButton));
        }
        logger.info("Item added to cart and automation rotated to basket page.");
    }

}
