package io.pragra.learning.drivermanager;

import io.pragra.learning.conf.FrameWorkConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static DriverManager manager;

    private WebDriver driver;

    private DriverManager() {
        if (FrameWorkConfig.getProperty("browser.type").equalsIgnoreCase(BrowserTypes.CHROME)){
            if( System.getProperty("os.name").toUpperCase().contains("MAC")||System.getProperty("os.name").toUpperCase().contains("LINUX")){
                System.setProperty(BrowserTypes.WEBDRIVER_CHROME, FrameWorkConfig.getProperty("driver.location")+"chromedriver");
            }else if(System.getProperty("os.name").toUpperCase().contains("WIN")){
                System.setProperty(BrowserTypes.WEBDRIVER_CHROME, FrameWorkConfig.getProperty("driver.location")+"chromedriver.exe");
            }

            driver = new ChromeDriver();
        }else if (FrameWorkConfig.getProperty("browser.type").equalsIgnoreCase(BrowserTypes.FIREFOX)){
            System.setProperty(BrowserTypes.WEBDRIVER_FIREFOX, FrameWorkConfig.getProperty("driver.location"));
            driver = new FirefoxDriver();
        }
        else if (FrameWorkConfig.getProperty("browser.type").equalsIgnoreCase(BrowserTypes.SAFARI)){
            System.setProperty(BrowserTypes.WEBDRIVER_SAFARI, FrameWorkConfig.getProperty("driver.location"));
            driver = new SafariDriver();
        }

        else {
            System.setProperty(BrowserTypes.WEBDRIVER_CHROME, FrameWorkConfig.getProperty("driver.location"));
            driver = new ChromeDriver();
        }

    }

    public synchronized static WebDriver getDriver(){
        if(manager == null)  {
            manager = new DriverManager();
        }
        return manager.driver;
    }
}
