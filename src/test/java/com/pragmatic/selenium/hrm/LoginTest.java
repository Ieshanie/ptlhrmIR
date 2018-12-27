package com.pragmatic.selenium.hrm;

import com.pragmatic.selenium.testng.ddt.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    public static final String BASE_URL=("http://hrm.pragmatictestlabs.com");

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(BASE_URL);


    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
    @Test
    public void testValidLogin(){
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
    driver.findElement(By.id("btnLogin")).click();
    String welcomeMessage=driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage,"Welcome Admin");
    }

  ///  @Test(dataProvider = "invalid-login-data",dataProviderClass = TestData.class)
   // public void testInvalidLogin(String username,String password,String expectedoutput){
      //  driver.findElement(By.id("txtUsername")).sendKeys(username);
      //  driver.findElement(By.id("txtPassword")).sendKeys(password);
      //  driver.findElement(By.id("btnLogin")).click();
      //  String msgError=driver.findElement(By.id("spanMessage")).getText();

  //  }

    @Test
    public void testBlankCredentials(){
        driver.findElement(By.id("txtUsername")).sendKeys("");
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("btnLogin")).click();
        String msgErrorBlank=driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(msgErrorBlank,"Username cannot be empty");
    }

    @Test
    public void testUsernameWithSpaces(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin ");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        String msgError=driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(msgError,"Welcome Admin");
    }

    @Test
    public void testLogOut(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        String welcomeMessage=driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage,"Welcome Admin");

        WebElement logOut =driver.findElement(By.id("welcome"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Logout")).click();
        System.out.println("Logout");
    }
}
