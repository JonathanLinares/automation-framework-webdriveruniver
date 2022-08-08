package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.BasePage;

import java.util.ArrayList;

public class Login_Steps extends BasePage {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() {
        navigateToURL("https://www.webdriveruniversity.com/");
    }

    @When("I click in login portal")
    public void i_click_in_login_portal() throws InterruptedException {
        waitForWebElementAndClick(By.xpath("//h1[contains(.,'LOGIN PORTAL')]"));
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(2000);
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username){
        sendKeys(By.xpath("//input[contains(@id,'text')]"),username);
    }

    @When("I enter a password {}")
    public void i_enter_a_password_webdriver123(String password) {
        sendKeys(By.xpath("//input[contains(@id,'password')]"),password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        waitForWebElementAndClick(By.xpath("//button[@id='login-button']"));
    }

    @Then("I validate the successfully message")
    public void i_validate_the_successfully_message() {
        String Successfully_Login = driver.switchTo().alert().getText();
        Assert.assertEquals(Successfully_Login,"validation succeeded");
    }

    @Then("I validate the unsuccessfully message")
    public void i_validate_the_unsuccessfully_message() {
        String Successfully_Login = driver.switchTo().alert().getText();
        Assert.assertEquals(Successfully_Login,"validation failed");
    }

    @Then("I validate the message {}")
    public void i_validate_the_message(String loginMessage) {
        String Successfully_Login = driver.switchTo().alert().getText();
        Assert.assertEquals(Successfully_Login,loginMessage);
    }

}
