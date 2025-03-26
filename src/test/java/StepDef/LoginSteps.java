package StepDef;

import CommonFiles.JPetBaseClass;
import Pages.LoginpPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import com.aventstack.extentreports.Status;
import static org.testng.Assert.*;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps extends JPetBaseClass {

    LoginpPage loginPage = new LoginpPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User already in JPetStore login page")
    public void user_already_in_j_pet_store_login_page() {
        try {
            Hooks.test.log(Status.INFO, "Navigating to JPetStore login page");

            loginPage.getSigninLink().click();
            Hooks.test.log(Status.PASS, "Clicked on Sign In link");

            System.out.println("User navigates to JPetStore login page");

        } catch (Exception e) {
            Hooks.test.log(Status.FAIL, "Failed to navigate to login page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        try {
            Hooks.test.log(Status.INFO, "Entering username: " + username);

            loginPage.getUsername().clear();
            loginPage.getPassword().clear();

            Thread.sleep(1000); // Optional, depends on site behavior

            loginPage.getUsername().sendKeys(username);
            loginPage.getPassword().sendKeys(password);

            Hooks.test.log(Status.PASS, "Entered credentials successfully");

            System.out.println("Entered username: " + username + ", password: " + password);

        } catch (Exception e) {
            Hooks.test.log(Status.FAIL, "Failed to enter credentials: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        try {
            loginPage.getLoginButton().click();
            Hooks.test.log(Status.PASS, "Clicked on Login button");

            System.out.println("Clicked on login button");

        } catch (Exception e) {
        	Hooks.test.log(Status.FAIL, "Failed to click login button: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("User should see an error message and stay on login page")
    public void user_should_see_error_message_and_stay_on_login_page() throws IOException, InterruptedException {
        try {
        	Hooks.test.log(Status.INFO, "Verifying error message on invalid login");

            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//ul[@class='messages']//li")));

            screenShot("Invalid_Login_Error");

            assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");

            String actualMessage = errorMsg.getText().trim();
            String expectedMessage = "Invalid username or password. Signon failed.";

            assertEquals(actualMessage, expectedMessage, "Unexpected error message!");

            Hooks.test.log(Status.PASS, "Error message displayed successfully: " + actualMessage);

            System.out.println("Error message validated: " + actualMessage);

        } catch (AssertionError ae) {
            screenShot("Invalid_Login_Failed_Assertion");
            Hooks.test.log(Status.FAIL, "Assertion failed: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            screenShot("Invalid_Login_Exception");
            Hooks.test.log(Status.FAIL, "Exception during error message validation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws IOException, InterruptedException {
        try {
        	Hooks.test.log(Status.INFO, "Verifying successful login");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Out")));

            screenShot("Valid_Login_Success");

            boolean isLoggedIn = driver.findElement(By.linkText("Sign Out")).isDisplayed();

            assertTrue(isLoggedIn, "Login failed!");

            Hooks.test.log(Status.PASS, "User logged in successfully. Sign Out link is visible.");

            System.out.println("Login successful, Sign Out button displayed");

        } catch (AssertionError ae) {
            screenShot("Valid_Login_Failed_Assertion");
            Hooks.test.log(Status.FAIL, "Login failed: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            screenShot("Valid_Login_Exception");
            Hooks.test.log(Status.FAIL, "Exception during login validation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
