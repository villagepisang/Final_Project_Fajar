package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepDef.Hooks;

import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps() {
        driver = Hooks.driver;
    }

    @Given("User is on Demoblaze homepage")
    public void user_is_on_homepage() {
        driver.get("https://www.demoblaze.com");
        loginPage = new LoginPage(driver);
    }

    @When("User opens login modal")
    public void open_login_modal() {
        loginPage.openLoginModal();
    }

    @And("User inputs username {string} and password {string}")
    public void input_credentials(String username, String password) {
        loginPage.enterUsernamePassword(username, password);
    }

    @And("User submits login form")
    public void submit_login_form() throws InterruptedException {
        loginPage.submitLogin();
        Thread.sleep(2000); // Optional: Use WebDriverWait for production use
    }

    @Then("User should see welcome message with username {string}")
    public void verify_login(String expectedUsername) throws InterruptedException {
        Thread.sleep(2000); // Wait for login success
        String actual = loginPage.getLoggedInUser();
        assertTrue(actual.contains(expectedUsername));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}