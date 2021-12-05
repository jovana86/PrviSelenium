import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestIFrame {
    private final String iFrameURL = "https://demoqa.com/frames";
@Test
public void TestIFrame(){
    WebDriver driver = openChrome ();

    try {
        driver.get ( iFrameURL );
        WebElement pageHeader = driver.findElement ( By.className ( "main-header" ) );
        pageHeader.isDisplayed ();
        System.out.println ("Text from main page is "+ pageHeader.getText ());


        WebElement iFrame = driver.findElement ( By.id ( "frame1" ) );
        driver.switchTo ().frame ( iFrame );

        WebElement sampleHeadinInFrame = driver.findElement ( By.id ( "sampleHeading" ) );
        sampleHeadinInFrame.isDisplayed ();

        System.out.println ( "Text from iFrame is " + sampleHeadinInFrame.getText () );

        driver.switchTo ().defaultContent ();
        System.out.println ("Text from main page is "+ pageHeader.getText ());
    } finally {
        driver.quit ();
    }
}





    public WebDriver openChrome(){
    ChromeOptions options = new ChromeOptions ();
//    options.addArguments (  new String []{"--start-maximized"});
    options.addArguments (  new String []{"--ignore-certificate-errors"});
    options.addArguments (  new String []{"--disable-popup-blocking"});

    options.addArguments (  new String []{"--incognito"});
    ChromeDriver driver=new ChromeDriver (options);
    return driver;
}
}
