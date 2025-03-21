package StepDef;

import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks extends JPetBaseClass {

    @Before   // Cucumber hook, runs before every scenario
    public void setup() {  
        invokeBrowser("Firefox");  // Launch browser
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExtentReport.getInstance(); // Start report
        System.out.println("Setup completed in Hooks");
    }

    @After    // Cucumber hook, runs after every scenario
    public void tearDown() throws InterruptedException {
        ExtentReport.getInstance().flush(); // End report
        closeBrowser(); // Close browser
        System.out.println("Teardown completed in Hooks");
    }
}
