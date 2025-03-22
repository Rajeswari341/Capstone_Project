package CommonFiles;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class JPetBaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static File src;
	
	//This method is used to invoke the browser
    public static void invokeBrowser(String browser) {
        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid Browser");
            driver = new ChromeDriver();
        }

        // Common setup for all browsers
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Method to load properties from file
    public Properties loadProperties() throws IOException {
    	String path = System.getProperty("user.dir") + "/JPetStoreProperties.properties";
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        }
		return prop;
    }
    
    public class ReadFromExcel {

        private static Workbook workbook;
        private static Sheet sheet;

        // Load Excel file and sheet
        public static void setExcelFile(String excelPath, String sheetName) throws IOException {
            FileInputStream fis = new FileInputStream(excelPath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        }

        // Get cell data by row and column index (without switch case)
        public static String getCellData(int rowNum, int colNum) {
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum); 
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }
    
    // Method to scroll to a specific element
    public static void scrollToElement(WebElement element) {
        // Scroll the element into view and adjust the scroll position
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100);"); // Adjust the offset as necessary
    }

    // Screenshot method for taking screenshot
    public static void screenShot(String name) throws IOException, InterruptedException {
    	Thread.sleep(1000);
        src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("./screenshots/" + name + ".png"));
    }

    // Close browser
    public static void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.quit();
    }
}
