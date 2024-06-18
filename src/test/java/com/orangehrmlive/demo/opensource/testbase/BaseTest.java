package com.orangehrmlive.demo.opensource.testbase;

import com.orangehrmlive.demo.opensource.propertyreader.PropertyReader;
import com.orangehrmlive.demo.opensource.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
