package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import Pages.AddToCartPage;

public class AddToCartPageTest extends JPetBaseClass {
    WebDriverWait wait;
    Properties prop;
    AddToCartPage addtocart;

    ExtentTest test;   // Extent Report Test instance for current test case

    @BeforeClass
    public void setupClass() throws IOException, InterruptedException {

        // Initialize Extent Reports instance
        ExtentReport.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load the test data properties
        prop = loadProperties();

        // Initialize Page Objects
        addtocart = new AddToCartPage(driver);
       

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
        System.out.println("All the Three items successfully added to cart");
    }

    @AfterClass
    public void teardownClass() {
       
        // Flush Extent Report results after class execution
        ExtentReport.getInstance().flush();

    }
}
