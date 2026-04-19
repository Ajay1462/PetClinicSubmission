package StepDefinations;

import PageObjects.AddOwnerObjects;
import Utilities.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddOwnerDef {
    public TextContext textContext;
    public AddOwnerObjects addOwnerObjects;
    public AddOwnerDef(TextContext textContext)
    {
        this.textContext=textContext;
        addOwnerObjects=textContext.pageObjectManager.getAddOwnerObjects();
    }

    @Then("user clicks on the Add Owner button inside find owners page")
    public void user_clicks_on_the_add_owner_button_inside_find_owners_page() {
        addOwnerObjects.setAddowner();
    }
    @Then("Enter First name as {string}")
    public void enter_first_name_as(String name) {
        addOwnerObjects.FirstName(name);

    }
    @Then("Enter Last name as {string}")
    public void enter_last_name_as(String lastname) {
        addOwnerObjects.lastName(lastname);
    }
    @Then("Enter Address as {string}")
    public void enter_address_as(String address) {
        addOwnerObjects.Address(address);
    }
    @Then("Enter City as {string}")
    public void enter_city_as(String city) {
        addOwnerObjects.City(city);
    }
    @Then("Enter Telephone as {string}")
    public void enter_telephone_as(String number) {
        addOwnerObjects.Telephone(number);
    }

    @And("Click on Add Owner button")
    public void clickOnAddownerButton() {
        addOwnerObjects.Addownerbtn();
    }

    @And("Verify Success Message is displayed successfully")
    public void verifySuccessMessageIsDisplayedSuccessfully() {
        addOwnerObjects.successmsg();
    }

    @And("Add pet to that owner")
    public void addPetToThatOwner() {
        addOwnerObjects.addpet();
    }

    @And("Enter Pet Name as {string}")
    public void enterPetNameAs(String Petname) {
        addOwnerObjects.Addpetname(Petname);
    }

    @And("Enter date of Birth as {string}")
    public void enterDateOfBirthAs(String Date) {
        addOwnerObjects.DOB(Date);
    }

    @And("Select Pet Type from dropdown")
    public void selectPetTypeFromDropdown() {
        addOwnerObjects.petType();
    }
    @And("click on Addpet button")
    public void clickOnAddpetButton() {
        addOwnerObjects.setAddpetButton();
    }
}
