package com.orangehrmlive.demo.opensource.testsuite;

import com.orangehrmlive.demo.opensource.customlisteners.CustomListeners;
import com.orangehrmlive.demo.opensource.pages.AddUserPage;
import com.orangehrmlive.demo.opensource.pages.AdminPage;
import com.orangehrmlive.demo.opensource.pages.HomePage;
import com.orangehrmlive.demo.opensource.pages.LoginPage;
import com.orangehrmlive.demo.opensource.testbase.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;


/***
 * 1.adminShouldAddUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * click On "Add" button
 * Verify "Add User" Text
 * Select User Role "Admin"
 * enter Employee Name "Ananya Dash"
 *  enter Username
 *  Select status "Disable"
 *  enter psaaword
 *  enter Confirm Password
 *  click On "Save" Button
 *  verify message "Successfully Saved"
 *
 * 2. searchTheUserCreatedAndVerifyIt().
 *  Login to Application
 *  click On "Admin" Tab
 *  Verify "System Users" Text
 *  Enter Username
 *  Select User Role
 *  Select Satatus
 *  Click on "Search" Button
 *  Verify the User should be in Result list.
 *
 * 3. verifyThatAdminShouldDeleteTheUserSuccessFully().
 *  Login to Application
 *  click On "Admin" Tab
 *  Verify "System Users" Text
 *  Enter Username
 *  Select User Role
 *  Select Satatus
 *  Click on "Search" Button
 *  Verify the User should be in Result list.
 *  Click on Check box
 *  Click on Delete Button
 *  Popup will display
 *  Click on Ok Button on Popup
 *  verify message "Successfully Deleted"
 *
 * 4. searchTheUserAndVerifyTheMessageRecordFound().
 *  Login to Application
 *  click On "Admin" Tab
 *  Verify "System Users" Text
 *  Enter Username <username>
 *  Select User Role <userRole>
 *             Enter EmployeeName <employeeName>
 *  Select Satatus <status>
 *  Click on "Search" Button
 *  verify message "(1) Record Found"
 *  Verify username <username>
 *  Click on Reset Tab
 *
 * Data Set
 * username userrole employeeName Status
 * Admin Admin Paul Collings Enable
 * Cassidy.Hope ESS Cassidy Hope Enable
 * Nina.Patel ESS Nina Patel Enable
 * Odis.Adalwin Admin Odis Adalwin Enable
 */

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    SoftAssert softAssert;
    Alert alert;
    String inputEmployeeName="Qwerty Qwerty LName";
    String inputUserName="FMLNameee";
    String inputStatus="Enabled";
    String inputRole="Admin";

    @BeforeMethod(alwaysRun = true)
    public void Init(){
        homePage= new HomePage();
        loginPage= new LoginPage();
        adminPage=new AdminPage();
        addUserPage= new AddUserPage();
        softAssert= new SoftAssert();

    }
    @Test(groups = {"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        // enter the email id
        loginPage.enterEmailId("Admin");
        // enter the password
        loginPage.enterPassword("admin123");
        // click on login button

        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        // click on admin button
        adminPage.clickOnAdminButton();
        // verify the system user text
        String expectedMessage="System Users";
        String actualMessage=adminPage.getSystemText();

        Assert.assertEquals(actualMessage,expectedMessage,"Not verify");
        // click on add button
        adminPage.clickOnAddButton();
        // verify add user text
        Assert.assertEquals("Add User",adminPage.getAddText(),"Not matched");
       //select user role
        adminPage.selectUserRole(inputRole);
        // enter emoplee name
        adminPage.enterEmployeeName(inputEmployeeName);

        Thread.sleep(2000);
        // select employee role
        adminPage.selectEmployeeRole(inputEmployeeName);
        Thread.sleep(2000);
        // select the user status
        adminPage.selectUserStatus(inputStatus);
    // enter the user name
        adminPage.enterUserName(inputUserName);

        adminPage.enterPassword("prime123");
        adminPage.enterConfirmPassword("prime123");
        adminPage.clickOnSave();
        Assert.assertEquals("Successfully Saved",adminPage.getSavedMessage(),"error message");
    }
    @Test(groups = {"smoke","regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        // enter the email id
        loginPage.enterEmailId("Admin");
        // enter the password
        loginPage.enterPassword("admin123");
        // click on login button

        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        // click on admin button
        adminPage.clickOnAdminButton();
        // verify the system user text
        String expectedMessage="System Users";
        String actualMessage=adminPage.getSystemText();
        Assert.assertEquals(actualMessage,expectedMessage,"Not verify");
        // enter the user name
        addUserPage.enterUserName(inputUserName);
        // select the user role
        addUserPage.selectUserRole(inputRole);
        // enter the emoloyee name
        addUserPage.enterEmployeeName(inputEmployeeName);

        Thread.sleep(2000);
        // select the employee role
        addUserPage.selectEmployeeRole(inputEmployeeName);
        Thread.sleep(2000);
        // select the user status
        addUserPage.selectUserStatus(inputStatus);
        // clcick on serach button
        addUserPage.clickOnSearchButton();
        // verify the user
        softAssert.assertEquals("(1) Record Found",addUserPage.getSeachText());
    }

    @Test(groups = "regression")
    public void  verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        // enter the email id
        loginPage.enterEmailId("Admin");
        // enter the password
        loginPage.enterPassword("admin123");
        // click on login button

        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        // click on admin button
        adminPage.clickOnAdminButton();
        // verify the system user text
        String expectedMessage="System Users";
        String actualMessage=adminPage.getSystemText();
        Assert.assertEquals(actualMessage,expectedMessage,"Not verify");

        // enter the user name
        addUserPage.enterUserName(inputUserName);
        // select the user role
        addUserPage.selectUserRole(inputRole);
        // enter the emoloyee name
        addUserPage.enterEmployeeName(inputEmployeeName);

        Thread.sleep(2000);
        // select the employee role
        addUserPage.selectEmployeeRole(inputEmployeeName);
        Thread.sleep(2000);
        // select the user status
        addUserPage.selectUserStatus(inputStatus);
        // clcick on serach button
        addUserPage.clickOnSearchButton();
        // verify the user
        softAssert.assertEquals("(1) Record Found",addUserPage.getSeachText());
        // verify the userName
        addUserPage.verifyUser(inputUserName);
        // click on user check box
        addUserPage.clickOnUserCheckbox();
        // click on delete the user
        addUserPage.clickOnDeleteUser();
        // click on pop up box
        addUserPage.clickOnPopUp();
        // verify the message of delete
        Assert.assertEquals("Successfully Deleted",addUserPage.getDeleteSuccessMessage(),"error message");

    }
    @Test(dataProvider = "usertest",dataProviderClass = TestData.class, alwaysRun = true,groups = "regression")
    public void  searchTheUserAndVerifyTheMessageRecordFound(String userName, String userrole, String employyename, String status) throws InterruptedException {
        // enter the email id
        loginPage.enterEmailId("Admin");
        // enter the password
        loginPage.enterPassword("admin123");
        // click on login button

        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        // click on admin button
        adminPage.clickOnAdminButton();
        // verify the system user text
        String expectedMessage="System Users";
        String actualMessage=adminPage.getSystemText();
        Assert.assertEquals(actualMessage,expectedMessage,"Not verify");

        // enter the user name
        addUserPage.enterUserName(userName);
        // select the user role
        addUserPage.selectUserRole(userrole);
        // enter the emoloyee name
        addUserPage.enterEmployeeName(employyename);

        Thread.sleep(2000);
        // select the employee role
        addUserPage.selectEmployeeRole(employyename);
        Thread.sleep(2000);
        // select the user status
        addUserPage.selectUserStatus(status);
        // clcick on serach button
        Thread.sleep(2000);
        addUserPage.clickOnSearchButton();

        // verify the user
        softAssert.assertEquals("(1) Record Found",addUserPage.getSeachText());
        // verify the userName
        addUserPage.verifyUser(userName);

        //click on reset button
        addUserPage.clickOnReset();


    }

}
