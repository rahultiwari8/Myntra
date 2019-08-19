package RunnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/resources/Login.feature",
		glue= {"stepDefinition"},
		dryRun=false
		)

public class Testrunner {

}
