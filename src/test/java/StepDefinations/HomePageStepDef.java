package StepDefinations;

import PageObjects.HomePageObjects;
import Utilities.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class HomePageStepDef {
    public TextContext textContext;
    public HomePageObjects homePageObjects;

    public HomePageStepDef(TextContext textContext)
    {
        this.textContext=textContext;
        homePageObjects=textContext.pageObjectManager.getHomePageObjects();
    }

    @Given("the user navigates to the PetClinic home page")
    public void the_user_navigates_to_the_pet_clinic_home_page() throws IOException {
        String url=textContext.baseclass.prop.getProperty("URL");
        homePageObjects.LandHomePage(url);

    }
    @When("the home page is fully loaded")
    public void the_home_page_is_fully_loaded() {
        homePageObjects.HomepageLoaded();
    }
    @Then("the pet image should be displayed")
    public void the_pet_image_should_be_displayed() {
        homePageObjects.Petimagedisplayed();
    }
    @Then("the image should have the correct {string} alt text")
    public void the_image_should_have_the_correct_alt_text(String WelcomeText) {
        homePageObjects.VerifyWelcomeText(WelcomeText);
    }


}
