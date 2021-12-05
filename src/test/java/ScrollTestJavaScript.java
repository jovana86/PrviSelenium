import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class ScrollTestJavaScript {
    private final String practiceFormURL = "https://demoqa.com/automation-practice-form";

    @Test
    public void scrollTest() {
        WebDriver driver = openChrome ();

        try {
            driver.get ( practiceFormURL );
            WebElement submitButton = driver.findElement ( By.id ( "submit" ) );
//            Dobro resenje za skrolovanje do konkretnog objekta
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript ( "arguments[0].scrollIntoView(true);", submitButton );
            submitButton.click ();


        } finally {
            driver.quit ();
        }


    }

    @Test
    public void radioButtonTest() {
        WebDriver driver = openChrome ();

        try {
            driver.get ( practiceFormURL );


            //Jezivo resenje

            WebElement otherRadioButton = driver.findElement ( By.xpath ( "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label" ) );


            otherRadioButton.click ();

//            List<WebElement> radioOptions = driver.findElements (By.xpath ( "//div[@class='custom-control custom-radio custom-control-inline']" ));
//            for (WebElement radioOption: radioOptions){
//                radioOption.click ();
//            }
//


        } finally {
            driver.quit ();

        }
    }


        @Test
        public void uploadButtonTest () {
        WebDriver driver = openChrome ();


            try {
                driver.get ( practiceFormURL );

                String directoryPath = System.getProperty ( "user.dir" );
                String separator = System.getProperty ( "file.separator" );
                String path = directoryPath + separator + "qaTester.jpg";

                WebElement uploadButton = driver.findElement (By.id ( "uploadPicture" ));
                uploadButton.sendKeys ( path );



            }finally {
                driver.quit ();
            }


            }




        public WebDriver openChrome () {
            ChromeOptions options = new ChromeOptions ();
//    options.addArguments (  new String []{"--start-maximized"});
            options.addArguments ( new String[]{"--ignore-certificate-errors"} );
            options.addArguments ( new String[]{"--disable-popup-blocking"} );

            options.addArguments ( new String[]{"--incognito"} );
            ChromeDriver driver = new ChromeDriver ( options );
            return driver;
        }
    }

