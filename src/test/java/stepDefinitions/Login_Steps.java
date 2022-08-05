package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.ArrayList;
import static driver.DriverFactory.getDriver;

public class Login_Steps {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() {
        driver.get("https://www.webdriveruniversity.com/");
    }

    @When("I click in login portal")
    public void i_click_in_login_portal(){
        driver.findElement(By.xpath("//h1[contains(.,'LOGIN PORTAL')]")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username){
        driver.findElement(By.xpath("//input[contains(@id,'text')]")).sendKeys(username);
    }

    @When("I enter a password {}")
    public void i_enter_a_password_webdriver123(String password) {
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
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
