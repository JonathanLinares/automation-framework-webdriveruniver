package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.Login_PageObject;

public class Login_Steps extends BasePage {

    private Login_PageObject login_pageObject;
    public Login_Steps(Login_PageObject login_pageObject){
        this.login_pageObject = login_pageObject;
    }

    @Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() {
        login_pageObject.navigateTo_WebDriverUniversity_HomePage();
    }

    @When("I click in login portal")
    public void i_click_in_login_portal() throws InterruptedException {
        login_pageObject.clickOn_LoginPortal_Button();
        swichTo_NewTab(1);
        Thread.sleep(2000);
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username){
        login_pageObject.setUsername(username);
    }

    @When("I enter a password {}")
    public void i_enter_a_password_webdriver123(String password) {
        login_pageObject.setPassword(password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        login_pageObject.clickOn_Login_Button();
    }

    @Then("I validate the successfully message")
    public void i_validate_the_successfully_message() {
        login_pageObject.validate_SuccessfullLogin_Message();
    }

    @Then("I validate the unsuccessfully message")
    public void i_validate_the_unsuccessfully_message() {
        login_pageObject.validate_UnsuccessfullLogin_Message();
    }

    @Then("I validate the message {}")
    public void i_validate_the_message(String loginMessage) {
        waitFoAlert_And_ValidateText(loginMessage);
    }

}
