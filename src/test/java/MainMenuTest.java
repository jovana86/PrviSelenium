import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainMenuTest {

    @Test

    public void TestAboutButton(){

        WebDriver driver = new ChromeDriver ();

        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );
        driver.get ( "https://www.saucedemo.com/" );

        LoginTest.stampaj ("[TEST] Login to saucedemo.com as a standard user" );

        //precondition
        WebElement userNameField = driver.findElement ( By.name ("user-name") );

        userNameField.sendKeys ( "standard_user" );

        WebElement passwordField = driver.findElement ( By.id ("password"));
        passwordField.sendKeys ( "secret_sauce" );

        WebElement logInButton = driver.findElement ( By.id ( "login-button" ));
        logInButton.click ();

        //test

        LoginTest.stampaj ("[TEST] Clicking on burger menu button" );


        WebElement burgerMenuButton = driver.findElement (By.className ( "bm-burger-button" ));
        Actions action = new Actions ( driver );
        action.moveToElement ( burgerMenuButton ).perform ();
        action.click ().build ().perform ();

        LoginTest.stampaj ("[TEST] Clicking on about button" );

//        WebElement aboutButton = driver.findElement (By.xpath ( "//*[@id=\"about_sidebar_link\"]" ));
//
//        action.moveToElement ( aboutButton ).perform ();
//        action.click ().build ().perform ();

//        LoginTest.stampaj ("[TEST] Checking if it is on the expected webpage" );
//
//        String currentURL = driver.getCurrentUrl ();
//
//        assert currentURL.equals ( "https://saucelabs.com/" ): "Error. Wrong URL. Expected to be on sauce labs, but I am on " + currentURL;




    }
}
