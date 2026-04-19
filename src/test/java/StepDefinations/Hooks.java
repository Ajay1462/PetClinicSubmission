package StepDefinations;

import Utilities.TextContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {
    public TextContext textContext;
    public Hooks(TextContext textContext)
    {
        this.textContext=textContext;
    }

    @After
    public void AfterTest(Scenario scenario) throws IOException
    {
        if (scenario.isFailed())
        {
            byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) textContext.baseclass.driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);

            scenario.attach(screenshot,"image/png","Failed Screenshot");
        }

        textContext.baseclass.driver.quit();
    }
}
