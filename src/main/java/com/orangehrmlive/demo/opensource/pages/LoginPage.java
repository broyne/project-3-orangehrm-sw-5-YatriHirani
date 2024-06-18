package com.orangehrmlive.demo.opensource.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.opensource.customlisteners.CustomListeners;
import com.orangehrmlive.demo.opensource.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;

    // For password
    @CacheLookup
    @FindBy(name = "password")
    WebElement passWordField;

    //for login Button
    @CacheLookup
    @FindBy(css = ".oxd-button")
    WebElement loginButton;
    //Login text of page
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginText;

    // checking error
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-alert-content oxd-alert-content--error']")
    WebElement errorMessage;

    public String getLoginText() {
        Reporter.log("Get text from login " );
        CustomListeners.test.log(Status.PASS, "Get login page text");
        String message = getTextFromElement(loginText);
        return message;
    }
    public void enterEmailId(String email){
        Reporter.log("Enter email "+email+" to username field"+email.toString());
        CustomListeners.test.log(Status.PASS,"Entered username is" +email);
        sendTextToElement(userName,email);
    }
    public void enterPassword(String password){
        Reporter.log("Enter password "+passWordField+" to password field"+password.toString());
        CustomListeners.test.log(Status.PASS,"Enter password" +passWordField);
        sendTextToElement(passWordField,password);
    }
    public void clickOnLoginButton(){
        Reporter.log("Clicking on login button");
        CustomListeners.test.log(Status.PASS,"click on Login button");
        clickOnElement(loginButton);
    }
    public String getErrorMessage(){
        Reporter.log("error message");
        CustomListeners.test.log(Status.PASS,"error message");
       return getTextFromElement(errorMessage);
    }
}
