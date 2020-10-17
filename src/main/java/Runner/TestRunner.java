package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/features/Login.feature",
		glue= {"StepDefinitions"},
		//monochrome = true,
		plugin = {"pretty","html:target/HTMLReports"}
		
		)

public class TestRunner {

}
