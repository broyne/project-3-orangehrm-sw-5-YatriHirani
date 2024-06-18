package com.orangehrmlive.demo.opensource.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.opensource.customlisteners.CustomListeners;
import com.orangehrmlive.demo.opensource.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement enterUserName;

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
    @FindBy(xpath = "//label[contains(text(),'User Role')]/following::div[1]")
    WebElement userRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']//span")
    List<WebElement> dropdownOptionsUser;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement searchText;


    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card']//div")
    List<WebElement> userRecordList;

    @CacheLookup
    @FindBy(xpath = "(//div[@role='cell'])[2]")
    WebElement userTextList;
    //user checkbox
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement userCheckbox;

    //delete user
    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement deleteUser;
    //confirmdeletButton
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement confirmdeleteButton;
    // delete message
    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement deleteMessage;

    //Reser button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;




    public void selectUserRole(String role) {
        Reporter.log("select the user "+role.toString());
        CustomListeners.test.log(Status.PASS,"select the user"+role);
        userRoleDropdown.click();
        for (WebElement option : dropdownOptionsUser) {
            if (option.getText().equals(role)) {
                option.click();
                break;
            }
        }
    }

    public void enterEmployeeName(String employeeName) {
        Reporter.log("send the employye name "+employeeName.toString());
        CustomListeners.test.log(Status.PASS,"send the employee name"+employeeName);
        sendTextToElement(employeeNameField,employeeName);
    }

    public void selectEmployeeRole(String role) {
        Reporter.log("Verify the employee role "+role.toString());
        CustomListeners.test.log(Status.PASS,"verified the employee role"+role);
        for (WebElement suggestion : employeeNameSuggestions) {
            if (suggestion.getText().equals(role)) {
                suggestion.click();
                break;
            }
        }
    }

    public void selectUserStatus(String role) throws InterruptedException {
        userStatusDropdown.click();
        Reporter.log("Verify the user status "+role.toString());
        CustomListeners.test.log(Status.PASS,"verified the user status"+role);
        Thread.sleep(2000);
        for (WebElement option : statusOptions) {
            if (option.getText().equals(role)) {
                option.click();
                break;
            }
        }
    }
    public void enterUserName(String name){
        Reporter.log("Verify the username "+name.toString());
        CustomListeners.test.log(Status.PASS,"verified the username"+name);
        sendTextToElement(enterUserName,name);
    }

    public void clickOnSearchButton(){
        Reporter.log("clicked on the seach button ");
        CustomListeners.test.log(Status.PASS,"clicked on search ");
        clickOnElement(searchButton);
    }

    public String getSeachText(){
        Reporter.log("Verify the text ");
        CustomListeners.test.log(Status.PASS,"verified text");
       return getTextFromElement(searchText);
    }
    public void verifyUser(String role) {
        Reporter.log("Verify the user "+role.toString());
        CustomListeners.test.log(Status.PASS,"verified the user"+role);
        for (WebElement suggestion : userRecordList) {
            if (suggestion.getText().equals(role)) {
                break;
            }
        }
    }



    public String getUserListText(){
        Reporter.log("Verify the text ");
        CustomListeners.test.log(Status.PASS,"verified text");
        return getTextFromElement(userTextList);
    }

    public void clickOnUserCheckbox(){
        Reporter.log("clicked on checkbox");
        CustomListeners.test.log(Status.PASS,"clicked on checkbox");
        clickOnElement(userCheckbox);
    }

    public void clickOnDeleteUser(){
        Reporter.log("clicked on delete user");
        CustomListeners.test.log(Status.PASS,"clicked on delete user ");
        clickOnElement(deleteUser);
    }

    public void clickOnPopUp(){
        Reporter.log("clicked on confirmed delete ");
        CustomListeners.test.log(Status.PASS,"clicked on yes delete button ");
        clickOnElement(confirmdeleteButton);
    }

    public String getDeleteSuccessMessage(){
        Reporter.log("Verify the deleted message ");
        CustomListeners.test.log(Status.PASS,"Verify the deleted message ");
        return getTextFromElement(deleteMessage);
    }
    public void clickOnReset(){
        Reporter.log("clicked on reset button ");
        CustomListeners.test.log(Status.PASS,"clicked on reset button ");
        clickOnElement(resetButton);
    }

}
