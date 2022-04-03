package io.pragra.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestDemoPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='page-header']/h2[1]")
    private WebElement pageHeading;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "00Nd0000007MFAl")
    private WebElement empCount;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "description")
    private WebElement info;

    @FindBy(xpath = "//fieldset/label[1]")
    private WebElement subscribe;

    @FindBy(id="btnSubmit")
    private WebElement submit;


    public RequestDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getHeading(){
        return this.pageHeading.getText();
    }

    public RequestDemoPage keyInEmail(String email){
        this.email.sendKeys(email);
        return this;
    }

    public RequestDemoPage keyInCompany(String company){
        this.company.sendKeys(company);
        return this;
    }

    public RequestDemoPage keyInFirstName(String fname){
        this.firstName.sendKeys(fname);
        return this;
    }
    public RequestDemoPage keyInLastNamr(String lname){
        this.lastName.sendKeys(lname);
        return this;
    }


    public RequestDemoPage keyInEmpCount(String count){
        this.empCount.sendKeys(count);
        return this;
    }

    public RequestDemoPage keyInPhone(String phone){
        this.phone.sendKeys(phone);
        return this;
    }

    public RequestDemoPage keyInCountry(){
        Select select = new Select(country);
        select.selectByValue("CA");
        return this;
    }

    public RequestDemoPage keyInState(){
        Select select = new Select(state);
        select.selectByValue("ON");
        return this;

    }

    public RequestDemoPage keyInZip(String zipcode){
        this.zipcode.sendKeys(zipcode);
        return this;
    }

    public RequestDemoPage keyInInfo(String info){
        this.info.sendKeys(info);
        return this;
    }

    public RequestDemoPage keyInSubscribe(){
        subscribe.click();
        return this;
    }


    public void submit(){
        this.submit.click();
    }
}

