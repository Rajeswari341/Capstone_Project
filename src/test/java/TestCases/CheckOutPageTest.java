package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.CheckOutPagePF;
import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;

public class CheckOutPageTest extends JPetBaseClass{
	 WebDriver driver;
	 WebDriverWait wait;
	 CheckOutPagePF checkoutpage;
	 ExtentTest test;


	 @BeforeClass
	 public void setupClass() throws IOException {
		 ExtentReport.getInstance();
	     driver = JPetBaseClass.driver;
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     checkoutpage = new CheckOutPagePF(driver);
	     ReadFromExcel.setExcelFile(System.getProperty("user.dir") + "/JPetShippingDetails.xlsx", "Sheet1");

	    }
	    
	    @Test
	    public void CheckOut() throws InterruptedException, IOException {
	    	 test = ExtentReport.createTest("CheckOut Process Test");
	    	checkoutpage.getProceed().click();
	    	Thread.sleep(1000);
	    	WebElement drop=checkoutpage.getDropdown();
	    	drop.click();
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(drop).click().perform();
	    	actions.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
	    	Thread.sleep(300);
	    	checkoutpage.getCardNumber().clear();
	    	checkoutpage.getCardNumber().sendKeys(ReadFromExcel.getCellData(0, 1));
	    	
	    	checkoutpage.getExpiryDate().clear();
	    	checkoutpage.getExpiryDate().sendKeys(ReadFromExcel.getCellData(1, 1));
	    	
	    	checkoutpage.getFirstName().clear();
	    	checkoutpage.getFirstName().sendKeys(ReadFromExcel.getCellData(2, 1));
	        
	    	checkoutpage.getLastName().clear();
	    	checkoutpage.getLastName().sendKeys(ReadFromExcel.getCellData(3, 1));
	        
	    	checkoutpage.getAddress1().clear();
	    	checkoutpage.getAddress1().sendKeys(ReadFromExcel.getCellData(4, 1));
	        
	    	checkoutpage.getAddress2().clear();
	    	checkoutpage.getAddress2().sendKeys(ReadFromExcel.getCellData(11, 1));
	        
	    	checkoutpage.getCity().clear();
	    	checkoutpage.getCity().sendKeys(ReadFromExcel.getCellData(5, 1));
	        
	    	checkoutpage.getState().clear();
	    	checkoutpage.getState().sendKeys(ReadFromExcel.getCellData(6, 1));
	        
	    	checkoutpage.getZip().clear();
	    	checkoutpage.getZip().sendKeys(ReadFromExcel.getCellData(7, 1));
	        
	    	checkoutpage.getCountry().clear();
	    	checkoutpage.getCountry().sendKeys(ReadFromExcel.getCellData(8, 1));
	        test.log(Status.INFO, "Entered billing details");

	    	checkoutpage.getCheckbox().click();
	    	Thread.sleep(300);
	    	checkoutpage.getSubmit().click();
	    	Thread.sleep(300);
	    	
	    	checkoutpage.getAddress_1().clear();
	    	checkoutpage.getAddress_1().sendKeys(ReadFromExcel.getCellData(9, 1));
	    	Thread.sleep(300);
	    	checkoutpage.getAddress_2().clear();
	    	checkoutpage.getAddress_2().sendKeys(ReadFromExcel.getCellData(10, 1));
	    	Thread.sleep(300);
	    	checkoutpage.getFnalSubmit().click();
	    	Thread.sleep(300);
	    	checkoutpage.getConfirm().click();
	    	
	    	 test.log(Status.INFO, "Clicked on Confirm Order button");

	         // Step 8: Screenshot after submission
	         screenShot("Page after Submission of Order");
	         test.log(Status.INFO, "Captured screenshot after submitting order");
	        		 
	    	WebElement OrderConfirmMsg = driver.findElement(By.xpath("//ul[@class='messages']"));
			String error = OrderConfirmMsg.getText();
			System.out.println(error);
			boolean s = OrderConfirmMsg.isDisplayed();			
			//Write the Validation part to make the test case pass/fail
			if(!s) {
				System.out.println("Order has't been submitted");
			} else {
				System.out.println("The Order Confirm msg is matched");
			}

			test.log(Status.PASS, "Order confirmation message displayed successfully");
			
			checkoutpage.getSignout().click();

	    }
	    
	    @AfterClass
	    public void close() throws InterruptedException {
	        ExtentReport.getInstance().flush();
	        closeBrowser();
	    }
	}