package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import Pages.LoginpPage;


public class LoginPageTest extends JPetBaseClass {

    WebDriver driver;
    WebDriverWait wait;
    Properties prop;

    LoginpPage loginPage;  // Page Object for Login Page
    ExtentTest test;       // Extent Report Test Instance

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {
        // Invoke the browser and initialize the driver
        invokeBrowser(browser);
        driver = JPetBaseClass.driver;  // Reference for local driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load test data from properties file
        prop = loadProperties();

        // Initialize Login Page Object
        loginPage = new LoginpPage(driver);

        // Start Extent Report Instance
        ExtentReport.getInstance();
    }

    @Test
    public void loginWithRegisteredUser() throws InterruptedException, IOException {

        // Create Extent Test
        test = ExtentReport.createTest("JPetStore - Login Test");

        // Navigate to JPetStore URL
        driver.get(prop.getProperty("url"));
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("url")));
        test.log(Status.INFO, "Navigated to JPetStore URL: " + prop.getProperty("url"));

        Thread.sleep(1000);  // Static wait (can be replaced with smarter waits)

        // Click on Sign In link
        WebElement signInLink = loginPage.getSigninLink();
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        test.log(Status.INFO, "Clicked on Sign In link");

        Thread.sleep(500);

        // Get credentials from properties file
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        // Log credential info (optional - avoid printing sensitive data in real-time reporting)
        System.out.println("Trying to log in with username: " + username);

        // Enter Username & Password
        loginPage.getUsername().clear();
        loginPage.getPassword().clear();
        loginPage.getUsername().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        test.log(Status.INFO, "Entered username and password");

        // Click on Login button
        loginPage.getLoginButton().click();
        test.log(Status.INFO, "Clicked on Login button");

        // Wait for page load or next expected element (You can enhance this later)
        Thread.sleep(1000);

        // Take Screenshot After Login
        screenShot("Page After Login");
        test.log(Status.PASS, "Successfully logged in and captured screenshot");

        // Optional: Verify user logged in successfully (if there's a user element or home page check)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Catalog.action"), "Login failed or not redirected to home page");
        test.log(Status.PASS, "User successfully navigated to Home page after login");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Flush Extent Report
        ExtentReport.getInstance().flush();

        // Close the browser
        closeBrowser();
    }
}
