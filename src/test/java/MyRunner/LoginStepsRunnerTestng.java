package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Features/LoginPage.feature",
    glue = "StepDef",
    plugin = {"pretty","html:target/cucumber.html"},
    tags="@signin or @invalidsignin",
    monochrome = true
)
public class LoginStepsRunnerTestng extends AbstractTestNGCucumberTests {
}
