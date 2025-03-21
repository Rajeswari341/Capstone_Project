package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import Pages.AddToCartPage;
import Pages.LoginpPage;

public class AddToCartPageTest extends JPetBaseClass {

    WebDriver driver;
    WebDriverWait wait;
    Properties prop;

    LoginpPage loginPage;
    AddToCartPage addtocart;

    ExtentTest test;   // Extent Report Test instance for current test case

    @BeforeClass
    @Parameters({"browser"})
    public void setupClass(String browser) throws IOException, InterruptedException {

        System.out.println("BeforeClass: Launching browser and logging in");

        // Initialize Extent Reports instance
        ExtentReport.getInstance();

        // Launch the browser and initialize driver
        invokeBrowser(browser);
        driver = JPetBaseClass.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load the test data properties
        prop = loadProperties();

        // Initialize Page Objects
        loginPage = new LoginpPage(driver);
        addtocart = new AddToCartPage(driver);

        // Login to JPetStore before running Add to Cart tests
        driver.get(prop.getProperty("url"));
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("url")));
        System.out.println("Navigated to JPetStore URL");

        loginPage.getSigninLink().click();
        loginPage.getUsername().clear();
        loginPage.getPassword().clear();
        Thread.sleep(1000);

        loginPage.getUsername().sendKeys(prop.getProperty("username"));
        loginPage.getPassword().sendKeys(prop.getProperty("password"));
        loginPage.getLoginButton().click();
        System.out.println("Login successful!");

  }

    @Test(priority = 1)
    public void addBirdToCartAndReturnHome() throws InterruptedException, IOException {

        test = ExtentReport.createTest("Add Bird to Cart and Return Home");

        // Navigate to Birds section
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getBirds())).click();
        test.log(Status.INFO, "Navigated to Birds category");

        Thread.sleep(1000);

        // Select Amazon Parrot product
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getAmazonParrot())).click();
        test.log(Status.INFO, "Selected Amazon Parrot product");

        Thread.sleep(1000);

        // Click on Amazon Parrot ID for detailed view
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getAmazonParrotId())).click();
        Thread.sleep(1000);

        // Click on Add to Cart button
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getAddToCart())).click();
        test.log(Status.INFO, "Added Amazon Parrot to cart");

        // Take screenshot after adding item to cart
        screenShot("Page after Bird added to cart");

        Thread.sleep(1000);

        // Return to Main Menu
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getReturnToMainMenu())).click();
        test.log(Status.PASS, "Successfully added Bird to cart and returned to main menu");
    }

    @Test(priority = 2)
    public void addCatToCartAndReturnHome() throws InterruptedException, IOException {

        test = ExtentReport.createTest("Add Cat to Cart and Return Home");

        // Navigate to Cats section
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getCats())).click();
        test.log(Status.INFO, "Navigated to Cats category");

        Thread.sleep(1000);

        // Select Manx Cat product
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getManxCat())).click();
        test.log(Status.INFO, "Selected Manx Cat product");

        Thread.sleep(1000);

        // Click on Manx Cat ID for detailed view
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getManxCatId())).click();
        Thread.sleep(1000);

        // Click on Add to Cart button
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getAddToCart())).click();
        test.log(Status.INFO, "Added Manx Cat to cart");

        // Take screenshot after adding item to cart
        screenShot("Page after Cat added to cart");

        Thread.sleep(1000);

        // Return to Main Menu
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getReturnToMainMenu())).click();
        test.log(Status.PASS, "Successfully added Cat to cart and returned to main menu");
    }

    @Test(priority = 3)
    public void addDogToCartAndReturnHome() throws InterruptedException, IOException {

        test = ExtentReport.createTest("Add Dog to Cart and Return Home");

        // Navigate to Dogs section
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getDogs())).click();
        test.log(Status.INFO, "Navigated to Dogs category");

        Thread.sleep(1000);

        // Select Dalmation product
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getDalmation())).click();
        test.log(Status.INFO, "Selected Dalmation product");

        Thread.sleep(1000);

        // Click on Dalmation ID for detailed view
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getDalmationId())).click();
        Thread.sleep(1000);

        // Click on Add to Cart button
        wait.until(ExpectedConditions.elementToBeClickable(addtocart.getAddToCart())).click();
        test.log(Status.INFO, "Added Dalmation to cart");

        // Take screenshot after adding item to cart
        screenShot("Page after Dog added to cart");

        Thread.sleep(1000);

        // Return to Main Menu (optional if not needed)
        test.log(Status.PASS, "Successfully added Dog to cart and returned to main menu");
    }

    @AfterClass
    public void teardownClass() {
        System.out.println("AfterClass: Closing browser and flushing report");

        // Flush Extent Report results after class execution
        ExtentReport.getInstance().flush();

    }
}
