package io.pragra.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlackTopBarPage {

    WebDriver driver;

    @FindBy(css = "#black-topbar>div>ul>li:nth-child(1)")
    protected WebElement requestDemoLink;
    @FindBy(css = "#black-topbar>div>ul>li:nth-child(2)")
    protected WebElement one888Link;
    @FindBy(css = "#black-topbar>div>ul>li:nth-child(3)")
    protected WebElement resourceDropDown;
    @FindBy(css = "#black-topbar>div>ul>li:nth-child(4)")
    protected WebElement support;

    protected WebElement downloadZoomLink;
    protected WebElement learningCenterLink;

    public BlackTopBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public RequestDemoPage clickRequestDemo(){
        this.requestDemoLink.click();
        return new RequestDemoPage(driver);
    }
}
