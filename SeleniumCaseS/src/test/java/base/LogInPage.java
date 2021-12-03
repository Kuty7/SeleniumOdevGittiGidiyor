package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LogInPage extends BasePage{

    By nickText = new By.ById("L-UserNameField");
    By passText = new By.ById("L-PasswordField");
    By logInButton = new By.ById("gg-login-enter");

    String logInMail = "kutay.ozbek@testinium.com";
    String logInPass = "deneme1234";

    String expectedUrl = "https://www.gittigidiyor.com/uye-girisi?s=1";


    public LogInPage(WebDriver driver){
        super(driver);
    }

    public void isLoginPageOpened() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        //Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void loginToAcc(){
        fillTextBox(nickText, logInMail);
        fillTextBox(passText, logInPass);
        clickElement(logInButton);
        logger.info("Login Successful!");
    }


}
