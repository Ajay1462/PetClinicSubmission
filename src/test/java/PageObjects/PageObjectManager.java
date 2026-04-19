package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;
    public HomePageObjects homePageObjects;
    public VeterinariansObject veterinariansObject;
    public FindOwnersObjects findOwnersObjects;
    public AddOwnerObjects addOwnerObjects;
    public VerifyOwnerDetailsObjects verifyOwnerDetailsObjects;

    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }
    public HomePageObjects getHomePageObjects()
    {
        homePageObjects=new HomePageObjects(driver);
        return homePageObjects;
    }
    public VeterinariansObject getVeterinariansObject()
    {
        veterinariansObject=new VeterinariansObject(driver);
        return veterinariansObject;
    }
    public FindOwnersObjects findOwnersObjects()
    {
        findOwnersObjects=new FindOwnersObjects(driver);
        return findOwnersObjects;
    }
    public AddOwnerObjects getAddOwnerObjects()
    {
        addOwnerObjects=new AddOwnerObjects(driver);
        return addOwnerObjects;
    }
    public VerifyOwnerDetailsObjects getverifyOwnerDetailsObjects()
    {
        verifyOwnerDetailsObjects= new VerifyOwnerDetailsObjects(driver);
        return verifyOwnerDetailsObjects;
    }


}
