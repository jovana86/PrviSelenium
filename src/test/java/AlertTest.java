//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.Test;
//
//public class AlertTest {
//
//    private final String alertPageURL ="https://demoqa.com/alerts";
//
//    @Test
//
//    public void AlertTest(){
//
//        WebDriver driver=openChrome ();
//        try {
//            driver.get  ( alertPageURL );
//            WebElement firstAlertButton = driver.findElement (By.id ( "alertButton" ));
//            firstAlertButton.click ();
//            Alert alert = driver.switchTo ().alert ();
//            String alertText = alert.getText ();
//            System.out.println (alertText);
//            WebElement promptAlertButton = driver.findElement (By.id ( "promtButton" ));
//            promptAlertButton.click ();
//             alert = driver.switchTo ().alert ();
//             alert.sendKeys ( "Ovo je ukucano u alertu: " );
//             alert.accept ();
//
//
//
//
//
//
//
//
//
//        } finally {
//            driver.quit ();
//        }
//    }
//
//
//
//
//    public WebDriver openChrome() {
//        ChromeOptions options = new ChromeOptions ();
////    options.addArguments (  new String []{"--start-maximized"});
//        options.addArguments ( new String[]{"--ignore-certificate-errors"} );
//        options.addArguments ( new String[]{"--disable-popup-blocking"} );
//
//        options.addArguments ( new String[]{"--incognito"} );
//        ChromeDriver driver = new ChromeDriver ( options );
//        return driver;
//    }
//}
