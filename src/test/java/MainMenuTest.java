import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainMenuTest {

    @Test

    public void TestAboutButton(){

//
//        WebDriver driver = login ();
//
//
        WebDriver driver = new ChromeDriver ();
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

        WebDriverWait wait = new WebDriverWait ( driver,30 );
        wait.until( ExpectedConditions.presenceOfElementLocated ( By.id("react-burger-menu-btn")));




        WebElement burgerMenuButton = driver.findElement (By.id ( "react-burger-menu-btn" ));
        burgerMenuButton.click ();

        LoginTest.stampaj ("[TEST] Clicking on about button" );

        sleep ();


        WebDriverWait wait1 = new WebDriverWait ( driver,40 );
        wait.until( ExpectedConditions.presenceOfElementLocated ( By.id("react-burger-cross-btn")));



                WebElement aboutButton = driver.findElement (By.id ( "about_sidebar_link" ));

                WebDriverWait wait2 = new WebDriverWait ( driver,30 );
                wait.until ( ExpectedConditions.elementToBeClickable ( By.id ( "about_sidebar_link" ) ) );


//                sleep ();
        aboutButton.click ();
//
//        Actions action = new Actions ( driver );
//        action.moveToElement ( aboutButton ).perform ();
//        action.click ().build ().perform ();

//        LoginTest.stampaj ("[TEST] Checking if it is on the expected webpage" );
//
        String currentURL = driver.getCurrentUrl ();

        assert currentURL.equals ( "https://saucelabs.com/" ): "Error. Wrong URL. Expected to be on sauce labs, but I am on " + currentURL;

        driver.quit ();


    }





    public WebDriver login(){
        WebDriver driver = new ChromeDriver ();



        driver.get("https://www.saucedemo.com/");

        LoginTest.stampaj("[TEST] Login to saucedemo.com as a standard user");

            //precondition
            WebElement userNameField = driver.findElement ( By.name ( "user-name" ) );

        userNameField.sendKeys("standard_user");

            WebElement passwordField = driver.findElement ( By.id ( "password" ) );
        passwordField.sendKeys("secret_sauce");

            WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
        logInButton.click();

        String currentURL = driver.getCurrentUrl ();
        assert currentURL.equals ( "https://www.saucedemo.com/inventory.html" ): "Error. Wrong URL. Expected to be on inventory page, but I am on " + currentURL;

        return driver;

        }

        public void sleep() {

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



        }


