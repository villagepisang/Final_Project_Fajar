package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartLink = By.id("cartur");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private By nameInput = By.id("name");
    private By countryInput = By.id("country");
    private By cityInput = By.id("city");
    private By cardInput = By.id("card");
    private By monthInput = By.id("month");
    private By yearInput = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By confirmation = By.className("sweet-alert"); // popup confirmation

    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    public void placeOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(countryInput).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(cardInput).sendKeys(card);
        driver.findElement(monthInput).sendKeys(month);
        driver.findElement(yearInput).sendKeys(year);
    }

    public void purchase() {
        driver.findElement(purchaseBtn).click();
    }

    public boolean isConfirmationDisplayed() {
        return driver.findElement(confirmation).isDisplayed();
    }
}
