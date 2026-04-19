package PageObjects;
import Utilities.WebDriverwait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddOwnerObjects {
    public WebDriver driver;
    public AddOwnerObjects(WebDriver driver)
    {
        this.driver=driver;
    }

    By FindOwnerButton= By.xpath("//span[text()='Find Owners']");
    By AddownerButton = By.xpath("//a[text()=\"Add Owner\"]");
    By Firstname=By.xpath("//input[@id='firstName']");
    By lastname = By.id("lastName");
    By Address = By.id("address");
    By City=By.id("city");
    By telephone=By.id("telephone");
    By AddSubmit = By.xpath("//button[@type='submit']");
    By Successmsg=By.id("success-message");
    By Addpetbtn = By.xpath("//a[text()='Add New Pet']");
    By petName = By.xpath("//input[@id='name']");
    By dateofbirth = By.id("birthDate");
    By PetType = By.id("type");
    By AddpetButton = By.xpath("//button[.='Add Pet']");
    By informationText=By.xpath("//h2[text()='Owner Information']");


    public void setAddowner()
    {
        driver.findElement(FindOwnerButton).click();
        driver.findElement(AddownerButton).click();
    }
    public void FirstName(String name)
    {
        driver.findElement(Firstname).sendKeys(name);
    }
    public void lastName(String last_name)
    {
        driver.findElement(lastname).sendKeys(last_name);
    }
    public void Address(String address)
    {
        driver.findElement(Address).sendKeys(address);
    }
    public void City(String city)
    {
        driver.findElement(City).sendKeys(city);
    }
    public void  Telephone(String tele_phone)
    {
        driver.findElement(telephone).sendKeys(tele_phone);
    }
    public void Addownerbtn()
    {
        driver.findElement(AddSubmit).click();
    }
    public void successmsg()
    {
        String Succesmsg=driver.findElement(Successmsg).getText();
        String expected_message="New Owner Created";
        Assert.assertEquals(Succesmsg,expected_message,"Not created");
    }
    public void addpet()
    {
       driver.findElement(Addpetbtn).click();
    }
    public void Addpetname(String petname)
    {
        driver.findElement(petName).sendKeys(petname);
    }
    public void DOB(String dob)
    {
        driver.findElement(dateofbirth).sendKeys(dob);
    }
    public void petType()
    {
        Select pettype = new Select(driver.findElement(PetType));
        pettype.selectByValue("dog");
    }
    public void setAddpetButton()
    {
        driver.findElement(AddpetButton).click();
        String infoText=driver.findElement(informationText).getText();
        Assert.assertEquals(infoText,"Owner Information","mismatched");
    }




}
