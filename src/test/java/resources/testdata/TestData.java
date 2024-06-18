package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    //@DataProvider(name = "login")
//    public Object[][] getData(){
//        Object[][] data= new Object[][]{
//                { "","","Required"},
//                { "test12@gmail.com","","Required"},
//                { "","test1234","Required"},
//                {"test123@gmail.com","test123","Invalid credentials"}
//        };
//        return data;
    //}
    @DataProvider(name = "usertest")
    public Object[][] getData(){
        Object[][] data= new Object[][]{
                { "FMLNameee","ESS" ,"Qwerty Qwerty LName"," Enabled" },
//                { "Cassidy.Hope"," ESS" ,"Cassidy Hope ","Enable "},
//                { "Nina.Patel"," ESS" ,"Nina Patel","Enable"},
//                {"Odis.Adalwin", "Admin Odis", "Adalwin", "Enable" }
        };
        return data;
    }



}
