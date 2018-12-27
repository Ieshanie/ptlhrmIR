package com.pragmatic.selenium.testng.ddt;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "invalid-login-data")

    public static Object[][] invalidLoginDetails(){
      return  new  Object[][]{
              {"Admin","","Invalid credentials"},
              {"","","UserName cannot be blank"},
                {"Admin","ptl@321","Invalid credentials"},
                 {"","","UserNme cannot be blank"}
      };
    }


}
