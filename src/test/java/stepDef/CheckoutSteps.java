package stepDef;

import io.cucumber.java.en.*;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.junit.Assert.*;

public class CheckoutSteps {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    public CheckoutSteps() {
        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) throws InterruptedException {
        loginPage.openLoginModal();
        Thread.sleep(1000);
        loginPage.enterUsernamePassword(username, password);
        loginPage.submitLogin();
        Thread.sleep(3000); // wait for login
    }

    @And("User selects a product and adds it to cart")
    public void user_adds_product_to_cart() throws InterruptedException {
        homePage.selectProduct();
        Thread.sleep(2000);
        productPage.addToCart();
        Thread.sleep(2000);
        driver.switchTo().alert().accept(); // accept alert
    }

    @And("User proceeds to checkout and fills in details")
    public void user_checkout() throws InterruptedException {
        cartPage.goToCart();
        Thread.sleep(2000);
        cartPage.placeOrder();
        Thread.sleep(1000);
        cartPage.fillForm("John Doe", "Indonesia", "Jakarta", "1234567890", "10", "2025");
        cartPage.purchase();
        Thread.sleep(2000);
    }

    @Then("Purchase confirmation should be displayed")
    public void purchase_confirmation() {
        assertTrue(cartPage.isConfirmationDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
