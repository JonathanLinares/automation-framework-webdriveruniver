package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.ContactUs_PageObject;


public class Contact_Us_Steps extends BasePage {

    private ContactUs_PageObject contactUs_pageObject;

    public Contact_Us_Steps(ContactUs_PageObject contactUs_pageObject){
        this.contactUs_pageObject = contactUs_pageObject;
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contactUs_pageObject.navigateTo_WebDriverUniversity_ContactUs();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contactUs_pageObject.setUnique_FirstName();
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contactUs_pageObject.setUnique_LastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contactUs_pageObject.setUnique_Email();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contactUs_pageObject.setUnique_Comment();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        contactUs_pageObject.setSpecific_FirstName(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contactUs_pageObject.setSpecific_LastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contactUs_pageObject.setSpecific_Email(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contactUs_pageObject.setSpecific_Comment(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contactUs_pageObject.clickOn_SubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        contactUs_pageObject.validate_Successful_SubmissionMessage_Text();
    }
}
