package com.pragmatic.selenium.testng;

import org.testng.annotations.Test;

public class TestngExample2 {
    @Test
    public void testMethod1(){
        System.out.println("TestngExample1.testMethod1");
    }

    @Test(enabled =false )
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
