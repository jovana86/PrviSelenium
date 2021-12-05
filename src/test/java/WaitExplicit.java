import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WaitExplicit {
@Test
    public void TestPerformanceGlitchUserLogin(){

        WebDriver driver=new ChromeDriver ();
        driver.get ( "https://www.saucedemo.com/" );
        WebElement userNameField = driver.findElement ( By.name ( "user-name" ) );
        userNameField.sendKeys ( "performance_glitch_user" );

        WebElement passwordField = driver.findElement ( By.id ( "password" ) );
        passwordField.sendKeys ( "secret_sauce" );

        WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
        logInButton.click ();

        String currentURL = driver.getCurrentUrl ();
        assert currentURL.equals ( "https://www.saucedemo.com/inventory.html" ) : "Error. Wrong URL. Expected to be on Login page, but I am on " + currentURL;

     driver.quit ();
    }

}
