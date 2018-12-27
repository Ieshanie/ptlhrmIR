package com.pragmatic.selenium.hrm.pages;

import com.pragmatic.selenium.hrm.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Define the element
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='txtPassword']/following::input[1]")
    WebElement btnLogin;

    @FindBy(xpath = "//span[@id='spanMessage']")
    WebElement msgError;



    //Add the actions
    public LoginPage txtUsername(String username) {
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage ClearAndTypeUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage txtPassword(String password) {
        txtUsername.click();
        txtPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginFailur() {
        btnLogin.click();
        return this;
    }

    public String getError() {

        return msgError.getText();
    }

    public LandingPage clickLoginSuccess(){
        btnLogin.click();
        return PageFactory.initElements(driver,LandingPage.class);
    }
}
