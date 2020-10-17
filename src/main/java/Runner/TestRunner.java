package Runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/features",
		glue= {"StepDefinitions"},
		tags="@TC02",
		dryRun=false,
		//monochrome = true,
		plugin = {"pretty","html:target/HTMLReports"}
		
		)

public class TestRunner {
	
}
