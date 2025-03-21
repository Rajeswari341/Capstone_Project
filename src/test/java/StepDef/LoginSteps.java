package StepDef;

import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import Pages.LoginpPage;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import static org.testng.Assert.*;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps extends JPetBaseClass {

    LoginpPage loginPage = new LoginpPage(driver);
    ExtentTest test;  // ExtentTest instance for reporting
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User navigates to JPetStore login page")
    public void user_navigates_to_login_page() {
        try {
            test = ExtentReport.createTest("Login Feature - Navigate to Login Page");

            driver.get("https://petstore.octoperf.com/actions/Catalog.action");
            test.log(Status.INFO, "Navigated to JPetStore Home Page");

            loginPage.getSigninLink().click();
            test.log(Status.PASS, "Clicked on Sign In link");

            System.out.println("User navigates to JPetStore login page");

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate to JPetStore login page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
        try {
            test.log(Status.INFO, "Entering credentials - Username: " + username);

            loginPage.getUsername().clear();
            loginPage.getPassword().clear();

            Thread.sleep(1000);

            loginPage.getUsername().sendKeys(username);
            loginPage.getPassword().sendKeys(password);

            test.log(Status.PASS, "Entered username and password successfully");

            Thread.sleep(1000);

            System.out.println("User enters username " + username + " and password " + password);

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to enter username and password: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        try {
            loginPage.getLoginButton().click();
            test.log(Status.PASS, "Clicked on Login button");
            System.out.println("User clicks on login button");

        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to click on login button: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws IOException, InterruptedException {
        try {
            test.log(Status.INFO, "Verifying successful login");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Out")));

            screenShot("Page after logged in with Valid Credentials");

            boolean isLoggedIn = driver.findElement(By.linkText("Sign Out")).isDisplayed();

            assertTrue(isLoggedIn, "Login failed!");

            test.log(Status.PASS, "User logged in successfully and Sign Out button is displayed");

            System.out.println("User should be logged in successfully");

        } catch (AssertionError ae) {
            screenShot("Login Failed");
            test.log(Status.FAIL, "Login failed! Sign Out button not found: " + ae.getMessage());
            throw ae;  // Optional: Re-throw if you want the test to fail
        } catch (Exception e) {
            screenShot("Exception during Login");
            test.log(Status.FAIL, "Exception occurred during login validation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("User should see an error message and stay on login page")
    public void user_should_see_error_message_and_stay_on_login_page() throws IOException, InterruptedException {
        try {
            test.log(Status.INFO, "Verifying failed login with invalid credentials");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Wait until error message appears
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//ul[@class='messages']//li")));

            screenShot("Page after logged in with Invalid Credentials");

            assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");

            String actualMessage = errorMsg.getText().trim();
            String expectedMessage = "Invalid username or password. Signon failed.";

            assertEquals(actualMessage, expectedMessage, "Unexpected error message!");

            test.log(Status.PASS, "Error message displayed successfully: " + actualMessage);

            System.out.println("Error message displayed: " + actualMessage);

        } catch (AssertionError ae) {
            screenShot("Error message validation failed");
            test.log(Status.FAIL, "Assertion failed: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            screenShot("Exception during Error Validation");
            test.log(Status.FAIL, "Exception occurred during error validation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
