package test;

import base.*;
import org.example.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTest extends BaseTest {

    BasePage basePage = new BasePage(driver);
    LogInPage logInPage = new LogInPage(driver);
    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage = new ProductPage(driver);
    BasketPage basketPage = new BasketPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);

    /*
    @Test
    public void userLogInTest() throws InterruptedException {
        homePage.pressLogIn();
        logInPage.loginToAcc();
    }

    @Test
    public void searchProductTest(){
        homePage.searchBoxInsertAndClick("Kolye");
    }

    @Test
    public void randomFavAddTest(){
        basePage.verticalScrollDown(10000);
        searchPage.randomFavAdd();
    }

    @Test
    public void returnHomePageAfterFavdTest(){
        searchPage.returnHomePage();
    }

    @Test
    public void addSpecifiedProductToCartTest(){
        homePage.searchBoxInsertAndClick("Çanta");
        searchPage.addToCartSpecific(6);
    }

    @Test
    public void goToCartFromProductPageTest() throws InterruptedException {
        productPage.addItemToCartAndGoToCart();
    }

    @Test
    public void quantityIncrementationTest(){
        basketPage.clickDropdown();
    }

    @Test
    public void goPaymentPageTest(){
        basketPage.clickGoToPayment();
    }

    @Test
    public void getErrorMessageTest(){
        paymentPage.clickToSaveButton();
        paymentPage.errorTextDecide();
    }

    @Test
    public void goToModifyTest(){
        paymentPage.clickArrangeBasket();
    }

    @Test
    public void addFromFavdTest(){
        basketPage.addFromFavs();
    }

    @Test
    public void removeFromFavdTest() throws InterruptedException {
        basketPage.deleteFavd();
    }

    @Test
    public void openHomeInNewTabTest(){
        basketPage.returnMainMenu();
        basePage.openNewTab();
    }

    @Test
    public void logOutTest(){
        homePage.logOut();
    }
    */

    @Test
    public void mainTest() throws InterruptedException{

        //homePage = new HomePage(driver);
        //logInPage = new LogInPage(driver);
        //basePage = new BasePage(driver);
        //searchPage = new SearchPage(driver);
        //productPage = new ProductPage(driver);
        //basketPage = new BasketPage(driver);
        //paymentPage = new PaymentPage(driver);

        //driver.manage().deleteAllCookies(); // Deletes all the cookies


        homePage.pressLogIn();

        logInPage.isLoginPageOpened();
        logInPage.loginToAcc();

        homePage.searchBoxInsertAndClick(searchPage.getSearchItem01());
        searchPage.isSearched(searchPage.getSearchItem01());

        basePage.verticalScrollDown(10000);

        searchPage.randomFavAdd();

        searchPage.returnHomePage();

        homePage.searchBoxInsertAndClick(searchPage.getSearchItem02());
        searchPage.isSearched(searchPage.getSearchItem02());

        searchPage.addToCartSpecific(6);

        //productPage.pressAddToCartButton();

        //productPage.pressGoToCartButton();

        //productPage.isTrueItemAdded();
        productPage.addItemToCartAndGoToCart();
        basketPage.isItemDisplayedInBasket();


        basketPage.clickDropdown();
        basketPage.amountComparator();

        basketPage.clickGoToPayment();

        paymentPage.clickToSaveButton();

        paymentPage.errorTextDecide();

        paymentPage.clickArrangeBasket();

        basketPage.addFromFavs();

        basketPage.deleteFavd();

        basketPage.returnMainMenu();

        basePage.openNewTab();

        homePage.logOut();
    }

}
