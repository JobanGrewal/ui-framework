package io.pragra.learning.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.pragra.learning.data.ContactDataProvider;
import io.pragra.learning.report.HtmlReport;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HomePageTest {
    HtmlReport report = new HtmlReport();
    ExtentTest test = report.createTest("DataProvider Test");


    @Test(dataProviderClass = ContactDataProvider.class, dataProvider = "contact")
    public void testValues(Object [] arr) {
           try {
            Assert.assertTrue(((String) arr[1]).length()>3);
            test.log(Status.PASS, "Name Length matches");
        }catch (Throwable ex) {
               test.log(Status.FAIL, "Name Length does not matches");
            throw  ex;
        }
    }

    @AfterClass
    public void tearDown() {
        report.closeTest();
    }
}
