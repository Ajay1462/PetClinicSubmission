Feature: Home Page Image Verification
  As a user
  I want to view the main image on the home page
  So that I can confirm the page is loaded correctly

  Scenario: Verify image on home page
    Given the user navigates to the PetClinic home page
    When the home page is fully loaded
    Then the pet image should be displayed
    And the image should have the correct "Welcome" alt text

  @Veterinarians
  Scenario: Find all the Veterinarians which are added in the application
    Given the user navigates to the PetClinic home page
    When the home page is fully loaded
    Then the pet image should be displayed
    And the image should have the correct "Welcome" alt text
    And user clicks on the Veterinarians button
    And all Veterinarian names are retrieved

  @FindingOwners
  Scenario: Find all the existing owners which are added in application
    Given the user navigates to the PetClinic home page
    When the home page is fully loaded
    Then the pet image should be displayed
    And the image should have the correct "Welcome" alt text
    And user clicks on the Find Owners button
    And all Owners names are retrieved


  @AddOwner
  Scenario Outline:Add a new owner, add pet for that owner.
    Given the user navigates to the PetClinic home page
    When the home page is fully loaded
    Then the pet image should be displayed
    And the image should have the correct "Welcome" alt text
    And user clicks on the Add Owner button inside find owners page
    And Enter First name as "<firstname>"
    And Enter Last name as "<lastname>"
    And Enter Address as "<address>"
    And Enter City as "<City>"
    And Enter Telephone as "<Number>"
    And Click on Add Owner button
    And Verify Success Message is displayed successfully
    And Add pet to that owner
    And Enter Pet Name as "<Petname>"
    And Enter date of Birth as "<DateOFBirth>"
    And Select Pet Type from dropdown
    And click on Addpet button

    Examples:
      | firstname | lastname | address | City | Number     | Petname | DateOFBirth |
      | Ajay      | Gadge    | Kothrud | Pune | 8618811873 | Chickoo | 18-04-2026  |


  @Verification
    Scenario:Check all the information added for the newly created owner and pet is correct.
      Given the user navigates to the PetClinic home page
      When the home page is fully loaded
      Then the pet image should be displayed
      And the image should have the correct "Welcome" alt text
      And user clicks on the Find Owners button
      And User Search for Recently Added Owner "Ajay"
      And Verify Owner details:
        | Name      | Ajay Gadge |
        | Address   | Kothrud    |
        | City      | Pune       |
        | Telephone | 8618811873 |
