package com.pragmatic.selenium.hrm.pages;

import com.pragmatic.selenium.hrm.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends TestBase {
    @FindBy(xpath ="//a[@id='welcome']")
    WebElement lnkWelcome;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement lnkLogut;

    public LoginPage logOut(){
        lnkWelcome.click();
        lnkLogut.click();
        return PageFactory.initElements(driver,LoginPage.class);
    }

    public String successMsg(){
        return  lnkWelcome.getText();
    }

}


