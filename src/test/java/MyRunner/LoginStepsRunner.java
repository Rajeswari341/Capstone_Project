package MyRunner;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
	features=".\\src\\test\\java\\Features\\LoginPage.feature",
	glue="StepDef", plugin= {"pretty"},monochrome=true)
 
public class LoginStepsRunner {
}
