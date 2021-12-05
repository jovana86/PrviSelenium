import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingList {
    @Test

    public void TestSortItemsByPriceAsc(){

        WebDriver driver = login ();

        List<WebElement> unsortedList = driver.findElements (  By.className ( "inventory_item" ));

        for(WebElement e : unsortedList) {
            String itemName = e.findElement ( By.className ( "inventory_item_name" ) ).getText ();
            String price = e.findElement ( By.className ( "inventory_item_price" ) ).getText ();

            System.out.println ("Cena za " + itemName + "je :" + price);

        }

        Select dropDown = new Select ( driver.findElement ( By.className ( "product_sort_container" ) ) );
        dropDown.selectByVisibleText ( "Price (low to high)" );

//        WebElement dropdown = driver.findElement (By.className ( "product_sort_container" ));
//        dropdown.click ();
//         WebElement sortHighToLow = dropdown.findElement (  By.xpath ("//option[text()='Price (high to low)']"  ));
//         sortHighToLow.click ();




        List<WebElement> sortedList = driver.findElements (  By.className ( "inventory_item" ));
        for(WebElement e : sortedList) {
            String itemName = e.findElement ( By.className ( "inventory_item_name" ) ).getText ();
            String price = e.findElement ( By.className ( "inventory_item_price" ) ).getText ();

            System.out.println ("Cena za " + itemName + "je :" + price);

        }
        String firstItemUnsorted = unsortedList.get ( 0 ).findElement ( By.className ( "inventory_item_price" ) ).getText ().replace ( "$","" );
        double firstItemUnsortedValue = Double.valueOf ( firstItemUnsorted );

        String firstItemSorted = sortedList.get ( 0 ).findElement ( By.className ( "inventory_item_price" ) ).getText ().replace ( "$","" );
        double firstItemSortedValue = Double.valueOf ( firstItemSorted );

        assert firstItemUnsortedValue>=firstItemSortedValue: "Error. Items are not sorted";



        driver.quit();
    }

    @Test

    public void TestSortItemsByPriceDsc() {

        WebDriver driver = login ();

        List<WebElement> unsortedList = driver.findElements ( By.className ( "inventory_item" ) );

        for (WebElement e : unsortedList) {
            String itemName = e.findElement ( By.className ( "inventory_item_name" ) ).getText ();
            String price = e.findElement ( By.className ( "inventory_item_price" ) ).getText ();

            System.out.println ( "Cena za " + itemName + "je :" + price );

        }

        Select dropDown = new Select ( driver.findElement ( By.className ( "product_sort_container" ) ) );
        dropDown.selectByVisibleText ( "Price (high to low)" );


        List<WebElement> sortedList = driver.findElements (  By.className ( "inventory_item" ));
        for(WebElement e : sortedList) {
            String itemName = e.findElement ( By.className ( "inventory_item_name" ) ).getText ();
            String price = e.findElement ( By.className ( "inventory_item_price" ) ).getText ();

            System.out.println ("Cena za " + itemName + "je :" + price);

        }
        String firstItemUnsorted = unsortedList.get ( 0 ).findElement ( By.className ( "inventory_item_price" ) ).getText ().replace ( "$","" );
        double firstItemUnsortedValue = Double.valueOf ( firstItemUnsorted );

        String firstItemSorted = sortedList.get ( 0 ).findElement ( By.className ( "inventory_item_price" ) ).getText ().replace ( "$","" );
        double firstItemSortedValue = Double.valueOf ( firstItemSorted );

        assert firstItemUnsortedValue<=firstItemSortedValue: "Error. Items are not sorted";

        driver.quit();

    }

    @Test

    public void TestSortItemsByNameZToA() {

        WebDriver driver = login ();

        List<WebElement> unsortedList = driver.findElements ( By.className ( "inventory_item" ) );
        ArrayList<String>  unsortedArray = new ArrayList<> ();

        for (WebElement e : unsortedList) {
            String itemName = e.findElement ( By.className ( "inventory_item_name" ) ).getText ();
            unsortedArray.add ( itemName );
            String price = e.findElement ( By.className ( "inventory_item_price" ) ).getText ();

            System.out.println ( "Cena za " + itemName + "je :" + price );

        }
        Collections.sort ( unsortedArray, Collections.reverseOrder () );
//
//
        Select dropDown = new Select ( driver.findElement ( By.className ( "product_sort_container" ) ) );
        dropDown.selectByVisibleText ( "Name (Z to A)" );

        ArrayList<String>  sortedArray = new ArrayList<> ();


        List<WebElement> sortedList = driver.findElements (  By.className ( "inventory_item" ));
        for(WebElement e : sortedList) {
            String itemName = e.findElement ( By.className ( "inventory_item_name" ) ).getText ();
            sortedArray.add ( itemName );
            String price = e.findElement ( By.className ( "inventory_item_price" ) ).getText ();

            System.out.println ("Cena za " + itemName + "je :" + price);

        }
        boolean isSorted = sortedArray.equals ( unsortedArray );
//
//        String firstItemUnsorted = unsortedList.get ( 0 ).findElement ( By.className ( "inventory_item_price" ) ).getText ().replace ( "$","" );
//        double firstItemUnsortedValue = Double.valueOf ( firstItemUnsorted );
//
//        String firstItemSorted = sortedList.get ( 0 ).findElement ( By.className ( "inventory_item_price" ) ).getText ().replace ( "$","" );
//        double firstItemSortedValue = Double.valueOf ( firstItemSorted );
//
//        assert firstItemUnsortedValue<=firstItemSortedValue: "Error. Items are not sorted";

        driver.quit();

//
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
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


