package io.pragra.learning.testcases;

import io.pragra.learning.conf.FrameWorkConfig;
import io.pragra.learning.drivermanager.DriverManager;
import io.pragra.learning.pages.BlackTopBarPage;
import io.pragra.learning.pages.RequestDemoPage;
import io.pragra.learning.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FrameworkTest {
    @Test
    public void testBrowserType() {
        String browser = FrameWorkConfig.getProperty("browser.type");

        Assert.assertEquals(browser,"CHROME","Mismatch of Broswertype");

    }

    @Test(enabled = true)
    public void testBrowserNullValue() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://pragra.io");
        String screenShot = Utils.captureScreenShot(driver, "testBrowserNullValue");
        System.out.println(screenShot);
        driver.quit();

    }

    @Test(enabled = false)
    public void checkFileName() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://amazon.com");
        String testScreenShot = Utils.captureScreenShot(driver,"AmazonHome");
        System.out.println(testScreenShot);

        boolean exists = Files.exists(Paths.get("target/test"));
        Assert.assertTrue(exists);

    }

    @Test
    public void osTest() throws InterruptedException {
       WebDriver driver = DriverManager.getDriver();
       driver.get("https://zoom.us");
        BlackTopBarPage topBarPage = new BlackTopBarPage(driver);

        RequestDemoPage demoPage = topBarPage.clickRequestDemo();
        Assert.assertEquals(demoPage.getHeading(), "Request a Demo");
        demoPage
                .keyInEmail("atin@abc.com")
                .keyInCompany("abc")
                .keyInFirstName("Atin")
                .keyInLastNamr("Singh")
                .keyInEmpCount("200")
                .keyInPhone("1234567")
                .keyInCountry()
                .keyInState()
                .keyInZip("1234")
                .keyInInfo("abcdef fd")
                .keyInSubscribe()
                .submit();
        Thread.sleep(5000);
        //System.out.println(driver.getTitle());
        driver.quit();
    }
}
