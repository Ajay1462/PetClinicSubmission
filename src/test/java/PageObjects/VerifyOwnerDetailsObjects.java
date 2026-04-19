package PageObjects;
import Utilities.WebDriverwait;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.Map;
public class VerifyOwnerDetailsObjects {
    public WebDriver driver;
    public WebDriverwait webDriverwait;

    public VerifyOwnerDetailsObjects(WebDriver driver) {
        this.driver = driver;
        this.webDriverwait = new WebDriverwait(driver);
    }

    By table_rows = By.xpath("//table//tbody//tr");
    By table_names = By.xpath("(.//td)[1]");
    By NextBTN = By.xpath("//a[@title='Next']");

    public By ownerDetailLabel(String label) {
        return By.xpath("//th[normalize-space()='" + label + "']/following-sibling::td");
    }


    public void Searchowner(String name) {
        boolean ownerfound = false;
        while (true) {
            List<WebElement> owners = driver.findElements(table_rows);
            for (WebElement owner : owners) {
                String currentowner = owner.findElement(table_names).getText();
                if (currentowner.contains(name)) {
                    owner.findElement(table_names).click();
                    ownerfound = true;
                    break;
                }
            }
            if (ownerfound) break;
            List<WebElement> next = driver.findElements(NextBTN);
            if (!next.isEmpty() && next.get(0).isDisplayed()) {
                WebElement firstRow = owners.get(0);
                next.get(0).click();
                webDriverwait.WaitStaleElement(firstRow);
            } else {
                break;
            }
        }

    }

    public String getOwnerDetail(String label) {
        return driver.findElement(ownerDetailLabel(label)).getText();
    }

    public void verifyOwnerDetails(DataTable dataTable) {
        Map<String, String> ExpectedData = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : ExpectedData.entrySet()) {
            String actualValue = getOwnerDetail(entry.getKey());
            String expectedValue = entry.getValue();
            Assert.assertEquals(actualValue, expectedValue, "Mismatch in " + entry.getKey());
        }
    }

}
