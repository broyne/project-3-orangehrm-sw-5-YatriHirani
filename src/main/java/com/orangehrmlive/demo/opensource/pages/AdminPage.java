package com.orangehrmlive.demo.opensource.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.opensource.customlisteners.CustomListeners;
import com.orangehrmlive.demo.opensource.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;


public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Admin']")
    WebElement adminButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addText;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'User Role')]/following::div[1]")
    WebElement userRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> dropdownOptionsUser;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;



    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> employeeNameSuggestions;



    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> statusOptions;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Status')]/following::div[1]")
    WebElement userStatusDropdown;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement enterUserName;

    @CacheLookup
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement enterConfirmPassword;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    WebElement saveButton;
      @CacheLookup
      @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
      WebElement successMessage;






    public void clickOnAdminButton(){
        Reporter.log("CLick on admin button ");
        CustomListeners.test.log(Status.PASS,"Click on admin button ");
        clickOnElement(adminButton);
    }
    public String getSystemText(){
        Reporter.log("Verify text "+ systemText.toString());
        CustomListeners.test.log(Status.PASS,"verify the text ");
        return getTextFromElement(systemText);
    }
    public void clickOnAddButton(){
        Reporter.log("CLick on add button ");
        CustomListeners.test.log(Status.PASS,"Click on add button ");
        clickOnElement(addButton);
    }
    public String getAddText(){
        Reporter.log("Verify text "+ addText.toString());
        CustomListeners.test.log(Status.PASS,"verify the add user text ");
        return getTextFromElement(addText);
    }
//    public void adminSelectionDropdown(){
//        Reporter.log("CLick on adminfield button"+adminFieldSelect);
//        CustomListeners.test.log(Status.PASS,"Click on addminfield button"+adminFieldSelect);
//       webElementList();
//    }

    public void selectUserRole(String role) {
        Reporter.log("select text "+ role.toString());
        CustomListeners.test.log(Status.PASS,"select the user role "+role);
        userRoleDropdown.click();
        for (WebElement option : dropdownOptionsUser) {
            if (option.getText().equals(role)) {
                option.click();
                break;
            }
        }
    }

    public void enterEmployeeName(String employeeName) {
        Reporter.log("send emplyee name  "+ employeeName.toString());
        CustomListeners.test.log(Status.PASS,"select employee name "+employeeName);
        sendTextToElement(employeeNameField,employeeName);
    }

    public void selectEmployeeRole(String role) {
        Reporter.log("select employee role "+ role.toString());
        CustomListeners.test.log(Status.PASS,"select the employee role "+role);
        for (WebElement suggestion : employeeNameSuggestions) {
            if (suggestion.getText().equals(role)) {
                suggestion.click();
                break;
            }
        }
    }


    public void selectUserStatus(String role) throws InterruptedException {
        Reporter.log("select user status "+ role.toString());
        CustomListeners.test.log(Status.PASS,"select user status  "+role);
        userStatusDropdown.click();
        Thread.sleep(2000);
        for (WebElement option : statusOptions) {
            if (option.getText().equals(role)) {
                option.click();
                break;
            }
        }
    }
    public void enterUserName(String name){
        Reporter.log("send the user name "+ name.toString());
        CustomListeners.test.log(Status.PASS,"enter the user name "+name);
        sendTextToElement(enterUserName,name);
    }
    public void enterPassword(String name){
        Reporter.log("enter the password"+ name.toString());
        CustomListeners.test.log(Status.PASS,"enter the password "+name);
        sendTextToElement(enterPassword,name);
    }
    public void enterConfirmPassword(String name){
        Reporter.log("enter the confirmed password"+ name.toString());
        CustomListeners.test.log(Status.PASS,"enter the confrimed password "+name);
        sendTextToElement(enterConfirmPassword,name);
    }
    public void clickOnSave(){
        Reporter.log("click on save button");
        CustomListeners.test.log(Status.PASS,"click on save button ");
        clickOnElement(saveButton);
    }
    public String getSavedMessage(){
        Reporter.log("get saved message");
        CustomListeners.test.log(Status.PASS,"get saved message");
        return getTextFromElement(successMessage);
    }
}
