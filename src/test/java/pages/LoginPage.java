package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginNavButton = By.id("login2");
    private By usernameInput = By.id("loginusername");
    private By passwordInput = By.id("loginpassword");
    private By loginModalButton = By.xpath("//button[text()='Log in']");
    private By loggedInUser = By.id("nameofuser");

    public void openLoginModal() {
        driver.findElement(loginNavButton).click();
    }

    public void enterUsernamePassword(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(loginModalButton).click();
    }

    public String getLoggedInUser() {
        return driver.findElement(loggedInUser).getText();
    }
}