package StepDefinations;
import PageObjects.VeterinariansObject;
import Utilities.TextContext;
import io.cucumber.java.en.Then;

public class VeterinariansStep {

    public TextContext textContext;
    public VeterinariansObject veterinariansObject;

    public VeterinariansStep(TextContext textContext)
    {
        this.textContext=textContext;
        veterinariansObject=textContext.pageObjectManager.getVeterinariansObject();

    }
    @Then("user clicks on the Veterinarians button")
    public void user_clicks_on_the_veterinarians_button() {
        veterinariansObject.setVeterinariansButton();

    }
    @Then("all Veterinarian names are retrieved")
    public void all_veterinarian_names_are_retrieved()
    {
        veterinariansObject.setTable_Data();
    }

}
