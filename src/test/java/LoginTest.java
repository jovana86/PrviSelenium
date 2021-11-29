import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class LoginTest {

    @Test

    public void loginTest() {
        WebDriver driver = new ChromeDriver ();
        driver.get ( "https://www.saucedemo.com/" );
        WebElement userNameField = driver.findElement ( By.name ("user-name") );
        userNameField.click ();
        userNameField.sendKeys ( "standard_user" );

        WebElement passwordField = driver.findElement ( By.id ("password"));
        passwordField.sendKeys ( "secret_sauce" );

        WebElement logInButton = driver.findElement ( By.id ( "login-button" ));
        logInButton.click ();

//        Kako potvrditi da smo dobili expected result

        String currentURL = driver.getCurrentUrl ();
//        assert currentURL.equals ( "https://www.saucedemo.com/inventory.html" ): "Error. Wrong URL. Expected to be on inventory page, but I am on " + currentURL;
        assert currentURL.contains ( "inventory" ): "Error. Wrong URL. Expected to be on inventory page, but I am on " + currentURL;

        WebElement titleOfPage = driver.findElement (By.className ( "title" )  );
        String currentTitleText = titleOfPage.getText ();
        assert currentTitleText.equals ( "Products" ): "Wrong title. Expected 'PRODUCTS'. Actual: " + currentTitleText;

        driver.quit ();



    }

    @Test

    public void testInvalidUsernameValidPass() {

        WebDriver driver = new ChromeDriver ();
        driver.get ( "https://www.saucedemo.com/" );
        WebElement userNameField = driver.findElement ( By.name ( "user-name" ) );
        userNameField.sendKeys ( "invalid_user" );

        WebElement passwordField = driver.findElement ( By.id ( "password" ) );
        passwordField.sendKeys ( "secret_sauce" );

        WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
        logInButton.click ();

        String currentURL = driver.getCurrentUrl ();
        assert currentURL.equals ( "https://www.saucedemo.com/" ) : "Error. Wrong URL. Expected to be on Login page, but I am on " + currentURL;
//        assert currentURL.contains ( "inventory" ): "Error. Wrong URL. Expected to be on inventory page, but I am on " + currentURL;

        WebElement errorMessage = driver.findElement ( By.xpath ( "//h3[@data-test = 'error']" ) );
        assert errorMessage.isDisplayed () : "Error message is not displayed";
        String errorMessageText = errorMessage.getText ();
        assert errorMessageText.equals ( "Epic sadface: Username and password do not match any user in this service" ) : "Wrong error" +
                "Expected: Epic sadface: Username and password do not match any user in this service " +
                "Actual: " + errorMessageText;

    }



          @Test

          public void TestInvalidPassValidUsername() {
            WebDriver driver = new ChromeDriver ();
            driver.get ( "https://www.saucedemo.com/" );

            stampaj ( "[TEST] Entering valid username" );

            WebElement userNameField = driver.findElement ( By.name ("user-name") );
            userNameField.sendKeys ( "standard_user" );

             stampaj ( "[TEST] Entering invalid password" );
            WebElement passwordField = driver.findElement ( By.id ("password"));
            passwordField.sendKeys ( "secret_cabbage" );

            stampaj ( "[TEST] Entering login button" );

            WebElement logInButton = driver.findElement ( By.id ( "login-button" ));
            logInButton.click ();

              stampaj ( "[TEST] Checking error message, is it displayed" );

            WebElement errorMessage = driver.findElement ( By.xpath ( "//h3[@data-test = 'error']" ) );
            assert errorMessage.isDisplayed (): "Error message is not displayed";

              stampaj ( "[TEST] Checking error message, is it wright message" );
            String errorMessageText = errorMessage.getText ();
            assert errorMessageText.equals ( "Epic sadface: Username and password do not match any user in this service" ): "Wrong error" +
                    "Expected: Epic sadface: Username and password do not match any user in this service " +
                    "Actual: " + errorMessageText;


              driver.quit ();

        }


        @Test

        public void TestINvalidUsernameInvalidPass(){
            WebDriver driver = new ChromeDriver ();
            driver.get ( "https://www.saucedemo.com/" );

            stampaj ( "[TEST] Entering invalid username" );

            WebElement userNameField = driver.findElement ( By.name ("user-name") );
            userNameField.sendKeys ( "carrot_user" );

            stampaj ( "[TEST] Entering invalid password" );
            WebElement passwordField = driver.findElement ( By.id ("password"));
            passwordField.sendKeys ( "secret_cabbage" );

            stampaj ( "[TEST] Entering login button" );

            WebElement logInButton = driver.findElement ( By.id ( "login-button" ));
            logInButton.click ();

            stampaj ( "[TEST] Checking error message, is it displayed" );

            WebElement errorMessage = driver.findElement ( By.xpath ( "//h3[@data-test = 'error']" ) );
            assert errorMessage.isDisplayed (): "Error message is not displayed";

            stampaj ( "[TEST] Checking error message, is it wright message" );
            String errorMessageText = errorMessage.getText ();
            assert errorMessageText.equals ( "Epic sadface: Username and password do not match any user in this service" ): "Wrong error" +
                    "Expected: Epic sadface: Username and password do not match any user in this service " +
                    "Actual: " + errorMessageText;


            driver.quit ();



        }

        @Test

        public void TestNoUsernameValidPass (){

                WebDriver driver = new ChromeDriver ();
                driver.get ( "https://www.saucedemo.com/" );

                stampaj ( "[TEST] Entering no username" );



                stampaj ( "[TEST] Entering valid password" );
                WebElement passwordField = driver.findElement ( By.id ( "password" ) );
                passwordField.sendKeys ( "secret_sauce" );

                stampaj ( "[TEST] Entering login button" );

                WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
                logInButton.click ();

                stampaj ( "[TEST] Checking error message, is it displayed" );

                WebElement errorMessage = driver.findElement ( By.xpath ( "//h3[@data-test = 'error']" ) );
                assert errorMessage.isDisplayed () : "Error message is not displayed";

                stampaj ( "[TEST] Checking error message, is it wright message" );
                String errorMessageText = errorMessage.getText ();
                assert errorMessageText.equals ( "Epic sadface: Username is required" ) : "Wrong error" +
                        "Expected: Epic sadface: Username is required" +
                        "Actual: " + errorMessageText;


                driver.quit ();
            }

            @Test

            public void TestValidUsernameNoPass(){

                WebDriver driver = new ChromeDriver ();
                driver.get ( "https://www.saucedemo.com/" );

                stampaj ( "[TEST] Entering valid username" );

                WebElement userNameField = driver.findElement ( By.name ( "user-name" ) );
                userNameField.sendKeys ( "standard_user" );

                stampaj ( "[TEST] Entering no password" );


                stampaj ( "[TEST] Entering login button" );

                WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
                logInButton.click ();

                stampaj ( "[TEST] Checking error message, is it displayed" );

                WebElement errorMessage = driver.findElement ( By.xpath ( "//h3[@data-test = 'error']" ) );
                assert errorMessage.isDisplayed () : "Error message is not displayed";

                stampaj ( "[TEST] Checking error message, is it wright message" );
                String errorMessageText = errorMessage.getText ();
                assert errorMessageText.equals ( "Epic sadface: Password is required" ) : "Wrong error" +
                        "Expected: Epic sadface: Password is required" +
                        "Actual: " + errorMessageText;


                driver.quit ();



            }

            @Test

            public void TestNoUsernameNoPass(){

                WebDriver driver = new ChromeDriver ();
                driver.get ( "https://www.saucedemo.com/" );

                stampaj ( "[TEST] Entering no username" );


                stampaj ( "[TEST] Entering no password" );


                stampaj ( "[TEST] Entering login button" );

                WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
                logInButton.click ();

                stampaj ( "[TEST] Checking error message, is it displayed" );

                WebElement errorMessage = driver.findElement ( By.xpath ( "//h3[@data-test = 'error']" ) );
                assert errorMessage.isDisplayed () : "Error message is not displayed";

                stampaj ( "[TEST] Checking error message, is it wright message" );
                String errorMessageText = errorMessage.getText ();
                assert errorMessageText.equals ( "Epic sadface: Username is required" ) : "Wrong error" +
                        "Expected: Epic sadface: Username is required" +
                        "Actual: " + errorMessageText;



                driver.quit ();


            }











    public static void stampaj(String s){
        System.out.println (s);
    }

}
