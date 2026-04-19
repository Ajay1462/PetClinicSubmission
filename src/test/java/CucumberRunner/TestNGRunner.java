package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features",glue = "StepDefinations",
        tags = "@Verification", monochrome = true,plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed_scenarios.txt"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNGRunner extends AbstractTestNGCucumberTests {

}
