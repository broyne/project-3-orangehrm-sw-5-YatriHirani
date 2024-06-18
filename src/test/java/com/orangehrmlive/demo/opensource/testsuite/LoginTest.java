package com.orangehrmlive.demo.opensource.testsuite;

import com.orangehrmlive.demo.opensource.customlisteners.CustomListeners;
import com.orangehrmlive.demo.opensource.pages.DashboardPage;
import com.orangehrmlive.demo.opensource.pages.HomePage;
import com.orangehrmlive.demo.opensource.pages.LoginPage;
import com.orangehrmlive.demo.opensource.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * 1. verifyUserShouldLoginSuccessFully()
 *     Enter username
 *     Enter password
 *     Click on Login Button
 *     Verify "WelCome" Message
 *
 * 2. verifyThatTheLogoDisplayOnHomePage()
 *     Login To The application
 *     Verify Logo is Displayed
 *
 * 3. verifyUserShouldLogOutSuccessFully()
 *     Login To The application
 *     Click on User Profile logo
 *     Mouse hover on "Logout" and click
 *     Verify the text "Login Panel" is displayed
 *
 * 4. verifyErrorMessageWithInvalidCredentials()
 *     Enter username <username>
 *     Enter password <password>
 *     Click on Login Button
 *             Verify Error message <errorMessage>
 * Test Data:
 *
 * username password errorMessage
 *   Required
 * test123@gmail.com  Required
 *  test123 Required
 * test123@gmail.com test123 Invalid credentials
 */


@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelData.xlsx";
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

//    @BeforeClass(alwaysRun = true)
//    public void setExcel() {
//        //Tell the code about the location of the excel file
//        try {
//            ExcelUtility.setExcelFile(FILE_PATH, "Sheet1");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @DataProvider(name = "datafromexcel")
//    public Object[][] getData() {
//        return ExcelUtility.getTestData("");
//    }


    @BeforeMethod(alwaysRun = true)
    public void Init(){
        homePage= new HomePage();
        loginPage= new LoginPage();
        dashboardPage= new DashboardPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void  verifyUserShouldLoginSuccessFully(){
        loginPage.enterEmailId("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Dashboard";
        String actualMessage = homePage.getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage, "Login page not displayed");

    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.enterEmailId("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(true,homePage.getlogo());
    }
    @Test(groups = "regression")
    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.enterEmailId("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        dashboardPage.clickOnUserLogo();
        Thread.sleep(2000);
        dashboardPage.clickOnLogout();
        Assert.assertEquals("Login",loginPage.getLoginText());
    }




    @Test (dataProvider = "login",dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String password,String error){
        loginPage.enterEmailId(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        if (error=="Required") {
           // String expectedMessage = "Invalid credentials";
            String actualMessage = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])")).getText();
            Assert.assertEquals(actualMessage, "Required", "Error message not displayed");
        }
        else {
            String expectedMessage = "Invalid credentials";
            String actualMessage = loginPage.getErrorMessage();
            Assert.assertEquals(error, expectedMessage, "Error message not displayed");

        }
    }
}
