package com.pragmatic.selenium.testng;

import com.pragmatic.selenium.testng.ddt.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngExample9  {
    @Test(dataProvider="invalid-login-data",dataProviderClass = TestData.class)
    public void testMethod1(String username,String password,String Expected_Result){
        System.out.println("username = [" + username + "], password = [" + password + "], Expected_Result = [" + Expected_Result + "]");
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
