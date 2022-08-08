package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactUs_PageObject extends BasePage{

    private @FindBy(xpath = "//form[@id='contact_form']/input[@name='first_name']")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//form[@id='contact_form']/input[@name='last_name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//form[@id='contact_form']/input[@name='email']")
    WebElement email_TextField;

    private @FindBy(xpath = "//form[@id='contact_form']/textarea[@name='message']")
    WebElement comment_TextField;

    private @FindBy(xpath = "//div[@id='form_buttons']/input[@value='SUBMIT']")
    WebElement submit_Button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmission_Message_Text;

    public ContactUs_PageObject(){
        super();
    }

    public void navigateTo_WebDriverUniversity_ContactUs(){
        navigateToURL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName(){
        sendKeys(firstName_TextField, "AutoFN" + generateRandomNumber(5));
    }

    public void setUnique_LastName(){
        sendKeys(lastName_TextField, "AutoLN" + generateRandomNumber(5));
    }

    public void setUnique_Email(){
        sendKeys(email_TextField, "AutoEmail" + generateRandomNumber(5) + "@mail.com");
    }

    public void setUnique_Comment(){
        sendKeys(comment_TextField, "This is a test " + generateRandomString(20));
    }

    public void setSpecific_FirstName(String firstName){
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecific_LastName(String lastName){
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecific_Email(String email){
        sendKeys(email_TextField, email);
    }

    public void setSpecific_Comment(String comment){
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_SubmitButton(){
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_Successful_SubmissionMessage_Text(){
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text.getText(), "Thank You for your Message!");
    }

}
