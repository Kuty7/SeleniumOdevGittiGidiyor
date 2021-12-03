package base;

import org.example.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage extends BasePage{

    By saveButton = new By.ByCssSelector("button.gg-ui-btn-primary.gg-btn.post-address.gg-ui-btn-fluid.post-address-button.gg-ui-btn-lg");
    By errorTextLocator = new By.ByCssSelector("div.gg-input-error-text.gg-d-24");
    By cartButtonLocator = new By.ByCssSelector("a.header-link.pl10");

    List<WebElement> arrangeCartLocators;

    public List<WebElement> getCartButtons(By by){
        return findAll(by);
    }

    public PaymentPage(WebDriver driver){
        super(driver);
    }

    public void clickToSaveButton(){
        clickElement(saveButton);
        logger.info("Save button clicked.");
    }

    public boolean isErrorDisplayed(){
        boolean kutySpecial = findElement(errorTextLocator).isDisplayed();
        Assert.assertTrue(kutySpecial);
        return kutySpecial;
    }

    public void errorTextDecide(){
        if(isErrorDisplayed()){
            System.out.println("Error Displayed!");
        }else {
            System.out.println("Error isn't Displayed!");
        }
        logger.info("Error display control finished.");
    }

    public void clickArrangeBasket(){
        arrangeCartLocators = getCartButtons(cartButtonLocator);

        clickWebElement(arrangeCartLocators.get(1));

        logger.info("Redirected to basket using arrange basket button.");
    }
}
