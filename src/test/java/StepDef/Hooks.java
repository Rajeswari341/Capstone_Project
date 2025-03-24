package StepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonFiles.ExtentReport;
import CommonFiles.JPetBaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends JPetBaseClass {
	public static ExtentTest test;

    @Before   // Runs before each scenario
    public void setup(Scenario scenario) {
        try {
            // Initialize ExtentReports if not already done
            ExtentReport.getInstance();

            // Create a new ExtentTest for each scenario
            test = ExtentReport.createTest(scenario.getName());

            System.out.println("Started ExtentTest for: " + scenario.getName());
            test.log(Status.INFO, "Starting scenario: " + scenario.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After    // Runs after each scenario
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
                // Optionally attach a screenshot here
            } else {
                test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
            }

            System.out.println("Finished scenario: " + scenario.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
