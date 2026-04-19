package StepDefinations;
import PageObjects.VerifyOwnerDetailsObjects;
import Utilities.TextContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class VerifyOwnerDetailsDef {
    public TextContext textContext;
    public VerifyOwnerDetailsObjects verifyOwnerDetailsObjects;
    public VerifyOwnerDetailsDef(TextContext textContext)
    {
        this.textContext=textContext;
        this.verifyOwnerDetailsObjects=textContext.pageObjectManager.getverifyOwnerDetailsObjects();
    }

    @And("User Search for Recently Added Owner {string}")
    public void userSearchForRecentlyAddedOwner(String Name) {
        verifyOwnerDetailsObjects.Searchowner(Name);
    }

    @And("Verify Owner details:")
    public void verifyOwnerDetails(DataTable dataTable) {
        verifyOwnerDetailsObjects.verifyOwnerDetails(dataTable);
    }
}
