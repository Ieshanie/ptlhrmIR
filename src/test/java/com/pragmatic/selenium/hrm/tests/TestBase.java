package com.pragmatic.selenium.hrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver=new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
