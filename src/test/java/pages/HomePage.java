package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By productLink = By.linkText("Samsung galaxy s6"); // bisa disesuaikan

    public void selectProduct() {
        driver.findElement(productLink).click();
    }
}
