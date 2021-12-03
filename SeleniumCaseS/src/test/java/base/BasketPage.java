package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketPage extends BasePage{

    //By ammountDropdown = new By.ByCssSelector("div.gg-input.gg-input-select.");

    //By ammountDropdown = new By.ByXPath("//*[@id='cart-item-514053137']/div[1]/div[4]/div/div[2]/select");

    By mainLogo = new By.ByCssSelector("a.logo_gg.imglink.logo-small");
    By deleteFavdButtonSpecified = new By.ByCssSelector("a[class='btn-delete']");
    By addToCartFromFav = new By.ByXPath("//*[@id='save-for-later-slider']/div/div/div/div/div/div/ul/li[6]/div/a[2]");
    By ammountLocator = new By.ByCssSelector("select[class='amount']");
    By ammountIncrement = new By.ByCssSelector(("select[class='amount'] option[value='2']"));
    By goToPaymentButton = new By.ByCssSelector("input.gg-d-24.gg-ui-btn-primary.gg-ui-btn-lg.btn-pay");
    By displayLocator = new By.ByCssSelector("div.gg-d-24.hidden-m.update-buttons-container");
    By buyAmountHolder = new By.ByCssSelector("input.amount.gg-w-24");

    JavascriptExecutor executor = (JavascriptExecutor)driver;

    List<WebElement> favDeleteButtons;

    public void amountComparator() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1500);
        String stringBuyAmountHolder = findElement(buyAmountHolder).getAttribute("value");
        Assert.assertEquals("2", stringBuyAmountHolder);
    }

    public void isItemDisplayedInBasket() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        Assert.assertTrue(isDisplayed(findElement(displayLocator)));
    }

    public List<WebElement> getAllSearchedItemsByLocator(By by) {
        return findAll(by);
    }

    public BasketPage (WebDriver driver){
        super(driver);
    }

    public void clickDropdown(){
        /*try {
            clickElement(ammountLocator);
        }catch (Exception e){
            executor.executeScript("arguments[0].click();", findElement(ammountLocator));
        }*/

        clickElement(ammountLocator);

        clickElement(ammountIncrement);

        logger.info("Product amount increment successful.");
    }

    public void clickGoToPayment(){
        clickElement(goToPaymentButton);
        logger.info("Redirected to payment page.");
    }

    public void addFromFavs (){
        clickElement(addToCartFromFav);
        logger.info("An item added to cart from favorites.");
    }

    public void deleteFavd () throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);

        favDeleteButtons = getAllSearchedItemsByLocator(deleteFavdButtonSpecified);

        try {
            favDeleteButtons.get(1).click();
        }catch (Exception e){
            executor.executeScript("arguments[0].click();", favDeleteButtons.get(1));
        }

        logger.info("Favorited item deleted from favorites.");
    }

    public void returnMainMenu(){
        clickElement(mainLogo);
        logger.info("Clicked main logo and redirected to main menu.");
    }

}
