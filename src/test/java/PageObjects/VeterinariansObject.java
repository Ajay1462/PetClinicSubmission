package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VeterinariansObject {
    public WebDriver driver;

    public VeterinariansObject(WebDriver driver) {
        this.driver = driver;
    }

    By veterinariansButton = By.xpath("//span[text()=\"Veterinarians\"]");
    By Table_Data = By.xpath("//table//tbody/tr");
    By VeretianName = By.xpath("td[1]");
    By Veretian_specilist = By.xpath("td[2]");
    By NextBtn = By.xpath("//a[@title='Next']");

    public void setVeterinariansButton() {
        driver.findElement(veterinariansButton).click();
    }

    public void setTable_Data() {
        boolean nextPagePresent = true;
        while (nextPagePresent) {
            List<WebElement> VeterianList = driver.findElements(Table_Data);
            for (WebElement veterianname : VeterianList) {
                String Name = veterianname.findElement(VeretianName).getText();
                String Speciality = veterianname.findElement(Veretian_specilist).getText();
                System.out.println(Name + " " + Speciality);
            }
            List<WebElement> nextButton = driver.findElements(NextBtn);
            if (!nextButton.isEmpty() && nextButton.get(0).isDisplayed()) {
                nextButton.get(0).click();
            } else {
                nextPagePresent = false;
            }
        }
    }
}
