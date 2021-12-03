package base;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage{

    WebElement specifiedFavButton;
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    String thirdProductAttribute;

    List<WebElement> allSearchedItems;
    List<WebElement> specificSearchedItems;
    List<WebElement> productsForTxt;


    WebElement specifiedElement;
    //By allSearchedItemsLocator = new By.ByCssSelector("li.sc-1nx8ums-0.dyekHG");
    By productsForTxtLocator = new By.ByCssSelector("a.sc-1n49x8z-1.izbuTw");
    By allSearchedFavBoxes = new By.ByCssSelector("div.ndodpt-1.bgCibU.sc-1n49x8z-13.ceCTui");
    By allSeachedItemLocators = new By.ByCssSelector("li.sc-1nx8ums-0.dyekHG");
    By mainLogo = new By.ByXPath("//*[@id='main-header']/div[4]/div/div/div/div[1]/div/div/a/div");
    By searchedBoxTxtHolder = new By.ByCssSelector("input.sc-4995aq-0.sc-14oyvky-0.geBqEx.czvYPr");
    Random rand = new Random();
    int randomThis;
    int favCounter = 0;
    boolean isFavd;

    String searchItem01 = "Kolye";
    String searchItem02 = "Çanta";

    public String getSearchItem01() {
        return searchItem01;
    }

    public void setSearchItem01(String searchItem01) {
        this.searchItem01 = searchItem01;
    }

    public String getSearchItem02() {
        return searchItem02;
    }

    public void setSearchItem02(String searchItem02) {
        this.searchItem02 = searchItem02;
    }

    public void isSearched(String searchedItemName){
        Assert.assertEquals(searchedItemName,findElement(searchedBoxTxtHolder).getAttribute("value"));
    }

    public List<WebElement> getAllSearchedItemsByLocator(By by) {
        return findAll(by);
    }

    public int randomNum(int bound){
        int num = rand.nextInt(bound);
        return num;
    }

    public void returnHomePage(){
        clickElement(mainLogo);
        logger.info("Returned to home page.");
    }

    public void addToCartSpecific(int itemIndex){
        specificSearchedItems = getAllSearchedItemsByLocator(allSeachedItemLocators);
        specifiedElement = specificSearchedItems.get(itemIndex);
        specifiedElement.click();
        logger.info("Specific item added to cart.");
    }

    public void randomFavAdd(){
        //driver.manage().deleteAllCookies(); // Deletes all the cookies

        allSearchedItems = getAllSearchedItemsByLocator(allSearchedFavBoxes);
        productsForTxt = getAllSearchedItemsByLocator(productsForTxtLocator);

        for (int i = 0; i < 4; i++){
            randomThis = ((randomNum(32)));

            //WebElement element = allSearchedItems.get(randomThis);
            //boolean isFavd = element.getAttribute("class") == "ndodpt-1 bgCibU sc-1n49x8z-13 dchmcc";

            isFavd = allSearchedItems.get(randomThis).getAttribute("class") == "ndodpt-1 bgCibU sc-1n49x8z-13 dchmcc";

            if (isFavd){
                i--;
                continue;
            }else {
                //verticalScrollDown(-1000);
                //hoverUsingElement(allSearchedItems.get(randomThis));

                specifiedFavButton = allSearchedItems.get(randomThis);
                specifiedElement = productsForTxt.get(randomThis);

                try {
                    allSearchedItems.get(randomThis).click();
                }catch (Exception e){
                    executor.executeScript("arguments[0].click();", specifiedFavButton);
                }

                if(i == 1){
                    //thirdProductAttribute = getProductAttribute(specifiedFavButton, "text");
                    thirdProductAttribute = getProductAttribute(specifiedElement, "title");
                    System.out.println(thirdProductAttribute);
                }


                //allSearchedItems.get(randomThis).click();


                //clickWebElement(allSearchedItems.get(randomThis));
                favCounter++;

                /*while (true){
                    isFavd = allSearchedItems.get(randomThis).getAttribute("class") == "ndodpt-1 bgCibU sc-1n49x8z-13 dchmcc";

                    if (!isFavd){
                        break;
                    }else {
                        //allSearchedItems.get(randomThis).click();
                        clickWebElement(allSearchedItems.get(randomThis));
                    }
                }*/


            }
            if (favCounter == 4){
                break;
            }
        }
        logger.info("4 products added to favorites.");
    }

    /*ublic List<Integer> randNums(int size){
        int temp = 0;
        List <Integer> nums = null;
        nums.add(randomNum(32));
        for (int i = 0; i < size; i++){
            temp = randomNum(32);
            for (int j = 0; j < nums.size(); j++){
                if (temp == nums.get(j)){
                    i--;
                    break;
                }
                if (j == nums.size()){
                    nums.add(temp);
                }
            }
        }
        return nums;
    }*/


    public void addToFav(){
        allSearchedItems = getAllSearchedItemsByLocator(allSeachedItemLocators);
    }


    public SearchPage(WebDriver driver){
        super(driver);
    }



}
