package PageObjects;
import Utilities.WebDriverwait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.IOException;

public class HomePageObjects {
    public WebDriver driver;
    public WebDriverwait webDriverwait;
    public HomePageObjects(WebDriver driver)
    {
        this.driver=driver;
    }

    By HomePageText = By.xpath("//a[@class='navbar-brand']");
    By PetImage = By.xpath("(//img)[1]");
    By welcomeText = By.xpath("//h2");

    public void LandHomePage(String expectedUrl) throws IOException {
        String actualurl =driver.getCurrentUrl();
        System.out.println(actualurl);
        Assert.assertEquals(actualurl,expectedUrl,"url mismatched");
    }
    public void HomepageLoaded()
    {
        webDriverwait=new WebDriverwait(driver);
        webDriverwait.waitForElementVisible(HomePageText);
    }
    public void Petimagedisplayed()
    {
        WebElement pet_image=driver.findElement(PetImage);
        Assert.assertTrue(pet_image.isDisplayed(),"image not present");
    }
    public void VerifyWelcomeText(String Text)
    {
        String WelcomeText=driver.findElement(welcomeText).getText();
        Assert.assertEquals(WelcomeText, Text,"Text not matched");
    }

}
