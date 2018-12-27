package com.pragmatic.selenium.hrm.tests;

import com.pragmatic.selenium.hrm.pages.LandingPage;
import com.pragmatic.selenium.hrm.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void testLoginWithBlankUsername(){
        //
        //
        LoginPage loginPage= PageFactory.initElements(driver,LoginPage.class);
        loginPage.txtUsername("").txtPassword("Ptl@#321").clickLoginFailur();
        Assert.assertEquals(loginPage.getError(),"Username cannot be empty");
    }

    @Test
    public void testLoginWithInValidCredentials(){
        LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
        loginPage.txtUsername("Admin").txtPassword("").clickLoginFailur();
        Assert.assertEquals(loginPage.getError(),"Password cannot be empty");
    }

    @Test
    public void testLoginWithValidCredentioals(){
        LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
        LandingPage landingPage=loginPage.txtUsername("Admin").txtPassword("Ptl@#321").clickLoginSuccess();

        Assert.assertEquals(landingPage.successMsg(),"Welcome Admin");
    }
}
