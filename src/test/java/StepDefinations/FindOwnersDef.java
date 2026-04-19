package StepDefinations;
import PageObjects.FindOwnersObjects;
import Utilities.TextContext;
import io.cucumber.java.en.Then;


public class FindOwnersDef {

    public TextContext textContext;
    public FindOwnersObjects findOwnersObjects;
    public FindOwnersDef(TextContext textContext)
    {
        this.textContext=textContext;
        findOwnersObjects=textContext.pageObjectManager.findOwnersObjects();

    }
    @Then("user clicks on the Find Owners button")
    public void user_clicks_on_the_find_owners_button() {
        findOwnersObjects.setFindOwnerButton();
    }
    @Then("all Owners names are retrieved")
    public void all_owners_names_are_retrieved() throws InterruptedException {
        findOwnersObjects.setOwnersTable();
    }
}
