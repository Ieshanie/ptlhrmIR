package com.pragmatic.selenium.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNGBase {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("TestNGBase.beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("TestNGBase.afterSuite");
    }
}
