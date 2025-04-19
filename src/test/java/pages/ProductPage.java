package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartBtn = By.xpath("//a[text()='Add to cart']");

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }
}
