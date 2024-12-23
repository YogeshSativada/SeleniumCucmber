package ruuner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue="steps",
		features="src\\test\\resources\\features\\regression\\ValidateLogin.feature",
		dryRun=false,
		tags="@regression")

public class regressionRunner {


}
