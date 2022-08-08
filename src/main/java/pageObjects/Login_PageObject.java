package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Login_PageObject extends BasePage {

    private @FindBy(xpath = "//input[contains(@id,'text')]")
    WebElement username_TextField;

    private @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement password_TextField;

    private @FindBy(xpath = "//button[@id='login-button']")
    WebElement login_Button;

    private @FindBy(xpath = "//h1[contains(.,'LOGIN PORTAL')]")
    WebElement loginPortal_Button;

    public Login_PageObject() {
        super();
    }

    public void navigateTo_WebDriverUniversity_HomePage(){
        navigateToURL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE_URL);
    }

    public void setUsername(String username){
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password){
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_Button);
    }

    public void clickOn_LoginPortal_Button(){
        waitForWebElementAndClick(loginPortal_Button);
    }

    public void validate_SuccessfullLogin_Message(){
        waitFoAlert_And_ValidateText("validation succeeded");
    }

    public void validate_UnsuccessfullLogin_Message(){
        waitFoAlert_And_ValidateText("validation failed");
    }
}
