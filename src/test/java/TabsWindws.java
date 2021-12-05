import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class TabsWindws {
    private final String browserWindowURL = "https://demoqa.com/browser-windows";

    @Test
    public void switchingToTabTest() {
        WebDriver driver = openChrome ();


        try {
            driver.get ( browserWindowURL );
            WebElement tabButton = driver.findElement ( By.id ( "tabButton" ) );
            tabButton.click ();

            List<String> tabs = new ArrayList<> ( driver.getWindowHandles () );
            driver.switchTo ().window ( tabs.get ( 1 ) );
            driver.close ();
            driver.switchTo ().window ( tabs.get ( 0 ) );

        } finally {
            driver.quit ();
        }


    }

    @Test
    public void switchingToWindowTest() {


        WebDriver driver = openChrome ();


        try {
            driver.get ( browserWindowURL );
            WebElement newWindowButton = driver.findElement ( By.id ( "windowButton" ) );
            newWindowButton.click ();
//            String parentWindow = driver.getWindowHandle ();

            List<String> tabs = new ArrayList<> ( driver.getWindowHandles () );
            driver.switchTo ().window ( tabs.get ( 1 ) );
            WebElement newWindowHeading = driver.findElement ( By.id ( "sampleHeading" ) );
            System.out.println ("This is new Window heading " + newWindowHeading.getText ());
            driver.close ();
            driver.switchTo ().window ( tabs.get ( 0 ) );
//            driver.switchTo ().window ( parentWindow );
//         Ovo je resenje za skrolovanje preko Seleniuma,skroluje do dna stranice,losije resenje
            newWindowButton.sendKeys ( Keys.PAGE_DOWN );


        } finally {
            driver.quit ();
        }
    }


    public WebDriver openChrome() {
        ChromeOptions options = new ChromeOptions ();
//    options.addArguments (  new String []{"--start-maximized"});
        options.addArguments ( new String[]{"--ignore-certificate-errors"} );
        options.addArguments ( new String[]{"--disable-popup-blocking"} );

        options.addArguments ( new String[]{"--incognito"} );
        ChromeDriver driver = new ChromeDriver ( options );
        return driver;
    }

}





