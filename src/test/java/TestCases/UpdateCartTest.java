package TestCases;

import java.io.IOException;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import Pages.UpdateCartPF;

public class UpdateCartTest extends JPetBaseClass {
    UpdateCartPF updatecart;
    ExtentTest test;  // For Extent Report test logs

    @BeforeClass
    public void setupClass() throws IOException {

        // Initialize Extent Report Instance
        ExtentReport.getInstance();
        // Initialize Page Factory for Update Cart Page
        updatecart = new UpdateCartPF(driver);

    }

    @Test
    public void updateCartTest() throws InterruptedException, IOException {

        test = ExtentReport.createTest("Update Cart Test");

        // Clear and update quantity for first product
        updatecart.getQuantity1().clear();
        updatecart.getQuantity1().sendKeys("3");
        test.log(Status.INFO, "Updated quantity of first item to 3");

        Thread.sleep(1000);

        // Clear and update quantity for second product
        updatecart.getQuantity2().clear();
        updatecart.getQuantity2().sendKeys("2");
        test.log(Status.INFO, "Updated quantity of second item to 2");

        Thread.sleep(1000);

        // Click on Update Cart button
        updatecart.getUpdateCart().click();
        test.log(Status.INFO, "Clicked on 'Update Cart' button to apply changes");

        Thread.sleep(1000);

        // Remove one item from cart
        updatecart.getRemove().click();
        test.log(Status.INFO, "Clicked on 'Remove' to delete an item from the cart");

        Thread.sleep(1000);

        // Click on Update Cart button again
        updatecart.getUpdateCart().click();
        test.log(Status.INFO, "Clicked on 'Update Cart' button to confirm removal");

        Thread.sleep(1000);

        // Take screenshot after cart update and removal
        screenShot("Page after update and removal in cart");

        // Final Pass log in ExtentReport
        test.log(Status.PASS, "Cart updated successfully - quantities modified and item removed");
        System.out.println("Updated the cart successfully by editing the quantity and removing one item");
    }

    @AfterClass
    public void tearDownClass() throws InterruptedException {

        // Flush Extent Report after test class execution
        ExtentReport.getInstance().flush();
    }
}
