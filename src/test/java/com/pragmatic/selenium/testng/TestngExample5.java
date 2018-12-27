package com.pragmatic.selenium.testng;

import org.testng.annotations.Test;

public class TestngExample5 {
    @Test(priority = 4)
    public void testMethod1(){
        System.out.println("TestngExample1.testMethod1");
    }

    @Test(priority = 0)
    public void testMethod2(){
        System.out.println("TestngExample1.testMethod2");
    }

    @Test(priority = 3)
    public void testMethod3(){
        System.out.println("TestngExample1.testMethod3");
    }

    @Test
    public void testMethod4(){
        System.out.println("TestngExample1.testMethod4");
    }

    @Test(priority = 2)
    public void testMethod5(){
        System.out.println("TestngExample1.testMethod5");
    }

}
