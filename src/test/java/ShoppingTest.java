import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ShoppingTest {

    @Test

    public void AddingOneItemToCartAndBuy(){

        WebDriver driver = new ChromeDriver ();
        driver.get ( "https://www.saucedemo.com/" );

//        Uloguj se kao registrovan korisnik
        WebElement userNameField = driver.findElement ( By.name ( "user-name" ) );
        userNameField.sendKeys ( "standard_user" );

        WebElement passwordField = driver.findElement ( By.id ( "password" ) );
        passwordField.sendKeys ( "secret_sauce" );

        WebElement logInButton = driver.findElement ( By.id ( "login-button" ) );
        logInButton.click ();

//        String currentURL = driver.getCurrentUrl ();
//        assert currentURL.equals ( "https://www.saucedemo.com/" ) : "Error. Wrong URL. Expected to be on Login page, but I am on " + currentURL;

//    Dodaj item u korpu


        WebDriverWait wait = new WebDriverWait ( driver,20 );
        wait.until( ExpectedConditions.presenceOfElementLocated ( By.id("add-to-cart-sauce-labs-bike-light")));


        WebElement bikeLightAddToCartButton = driver.findElement ( By.id ( "add-to-cart-sauce-labs-bike-light" ) );
        bikeLightAddToCartButton.click ();

//
//        Da li je dugme remove prisutno


        WebElement bikeLightremoveButton = driver.findElement ( By.id ( "remove-sauce-labs-bike-light" ) );
        assert bikeLightremoveButton.isDisplayed (): "Remove button is not displayed";

//        Da li ikonica cart pokazuje da je dodat jedan item u korpu


        WebElement shoppingCartBadge = driver.findElement (By.className ( "shopping_cart_badge" ));
        String numberInShoppingCartBadge = shoppingCartBadge.getText ();
        assert numberInShoppingCartBadge.equals ( "1" ): "Error. Expected 1. Actual  result : " + numberInShoppingCartBadge;

//        Idi na stranicu shopping cart


        WebElement shoopingCartLink = driver.findElement (By.className ( "shopping_cart_link" ));
        shoopingCartLink.click ();

        String currentURL = driver.getCurrentUrl ();
        assert currentURL.contains ( "cart" ): "Error. Wrong URL. Expected to be on cart page, but I am on " + currentURL;


//        Provera da li item dodat u kolica
        WebElement itemInCart = driver.findElement (By.className ( "inventory_item_name" ));
        String itemInCartTitle = itemInCart.getText ();
        assert itemInCartTitle.contains ( "Bike Light" ): "Error";

//                Idi na checkout

        WebDriverWait stay = new WebDriverWait ( driver,30 );
        wait.until( ExpectedConditions.presenceOfElementLocated ( By.xpath ("//*[@id='checkout']")));

        WebElement checkoutButton = driver.findElement ( By.xpath ( "//*[@id='checkout'] ") );
        checkoutButton.click ();

//        Unesi podatke

        WebDriverWait wait1 = new WebDriverWait ( driver,20 );
        wait.until( ExpectedConditions.presenceOfElementLocated ( By.id ("first-name")));

        WebElement firstName = driver.findElement (By.id ( "first-name" ));
        firstName.sendKeys ("Jovana");
        WebElement lastName = driver.findElement (By.id ( "last-name" ));
        lastName.sendKeys ("Basaric Pripunic");
        WebElement zipCode = driver.findElement (By.id ( "postal-code" ));
        zipCode.sendKeys ( "11550 ");

//        Idi na continue

        WebElement continueButton = driver.findElement (By.xpath ( "//input [contains(@class, 'submit-button')]" ));
        continueButton.click ();

        currentURL = driver.getCurrentUrl ();

        assert currentURL.contains ( "step-two" ) : "Error. Expected to be on checkout step two, overview page. Actual: You are on " + currentURL;


//   Zavrsi kupovinu
        WebElement finishShoppingButton  = driver.findElement (By.id ( "finish" ));
        finishShoppingButton.click ();

        WebElement checkoutComplete = driver.findElement (By.xpath ( "//span[text()='Checkout: Complete!']" ));
        assert checkoutComplete.isDisplayed (): "Error. Checkout complete is not displayed. ";

        driver.quit ();






    }
@Test
    public void ResetAppState() {
        WebDriver driver = login ();
        WebElement bikeLightAddToCartButton = driver.findElement ( By.id ( "add-to-cart-sauce-labs-bike-light" ) );
        bikeLightAddToCartButton.click ();

        WebElement shoppingCartBadge = driver.findElement (By.className ( "shopping_cart_badge" ));
        String numberInShoppingCartBadge = shoppingCartBadge.getText ();
        assert numberInShoppingCartBadge.equals ( "1" ): "Error. Expected 1. Actual  result : " + numberInShoppingCartBadge;

        WebElement burgerMenu = driver.findElement ( By.id ( "react-burger-menu-btn" ) );
        burgerMenu.click ();
        WebElement resetAppButton = driver.findElement ( By.id ( "reset_sidebar_link" ) );
        resetAppButton.click ();

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

//    public void sleep() {
//
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void switchingToTabTest(){


    }
}
