package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failed_scenarios.txt", glue = "StepDefinations",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-rerun.html",
                "json:target/cucumber-rerun.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class FailedRunner extends AbstractTestNGCucumberTests {
}
