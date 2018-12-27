package com.pragmatic.selenium.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngExample6 extends TestNGBase{
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("TestngExample6.beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("TestngExample6.afterMethod");
    }
    @Test
    public void testMethod1(){
        System.out.println("TestngExample1.testMethod1");
    }

    @Test
    public void testMethod2(){
        System.out.println("TestngExample1.testMethod2");
    }

    @Test
    public void testMethod3(){
        System.out.println("TestngExample1.testMethod3");
    }

    @Test
    public void testMethod4(){
        System.out.println("TestngExample1.testMethod4");
    }

    @Test
    public void testMethod5(){
        System.out.println("TestngExample1.testMethod5");
    }

}
