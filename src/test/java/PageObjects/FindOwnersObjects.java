package PageObjects;
import Utilities.WebDriverwait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FindOwnersObjects {
    public WebDriver driver;
    WebDriverwait webDriverwait;
    public FindOwnersObjects(WebDriver driver)
    {
        this.driver=driver;
    }
    By FindOwnerButton= By.xpath("//span[text()='Find Owners']");
    By FindButton = By.xpath("//button[text()='Find Owner']");
    By OwnersTable = By.xpath("//table//tbody/tr");
    By OwnerName = By.xpath(".//td[1] | .//td/a[1]");
    By OwnerNumber = By.xpath(".//td[4]");
    By PreviousBtn = By.xpath("//a[@title='Last']");
    By PreviosPageowners = By.xpath("//table//tbody/tr");

    public void setFindOwnerButton()
    {
        driver.findElement(FindOwnerButton).click();
        webDriverwait=new WebDriverwait(driver);
        webDriverwait.waitForElementVisible(FindButton);
        driver.findElement(FindButton).click();
    }
    public void setOwnersTable() throws InterruptedException {
        List<WebElement> ownersPage = driver.findElements(OwnersTable);

        for(WebElement owner : ownersPage) {
            String name = owner.findElement(OwnerName).getText();
            String number = owner.findElement(OwnerNumber).getText();

            System.out.println(name + " " + number);
        }
        driver.findElement(PreviousBtn).click();
        List<WebElement>Previousowners= driver.findElements(PreviosPageowners);
        webDriverwait.waitForTableReload(PreviosPageowners);
        Thread.sleep(500);
        for(WebElement owner:Previousowners)
        {
            String name = owner.findElement(OwnerName).getText();
            String number =owner.findElement(OwnerNumber).getText();
            System.out.println(name + " " + number);
        }

    }
}

