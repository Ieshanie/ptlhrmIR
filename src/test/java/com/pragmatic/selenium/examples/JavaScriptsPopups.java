package com.pragmatic.selenium.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptsPopups {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.navigate().to("http://demosite.pragmatictestlabs.com/Alerts.html");

    }

    @AfterMethod
    public void afterMethod(){
        webDriver.close();
    }

    @Test
    public void testAlert(){
        webDriver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();

        //Switch to the alert
        Alert alert=webDriver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"This Is Simple Alert");

        //Click the button
        alert.accept();

        //Verify the message in web page
        Assert.assertEquals(webDriver.findElement(By.id("confirm-demo")).getText(),"Alert is gone.");
    }


    @Test
    public void testConfirmationOK(){
    webDriver.findElement(By.xpath("//button[contains(text(),' Confirm Alert')]"));
    }


    @Test
    public void testConfirmationCancel(){

    }


    @Test
    public void testPromptInputTest(){
        String txtInputText = "selenium";
        webDriver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();

        //Switch to the alert
        Alert alert=webDriver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Please enter your name");


        alert.sendKeys(txtInputText);

        //Click the button
        alert.accept();

        //Verify the message in web page
        Assert.assertEquals(webDriver.findElement(By.id("confirm-demo")).getText(), txtInputText);


    }
    @Test
    public void testTimingAlert(){
        webDriver.findElement(By.xpath("//button[contains(text(),'Timing Alert')]")).click();
        //Explicit wait

        WebDriverWait wait= new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.alertIsPresent());

        //Switch to the alert
        Alert alert=webDriver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"This is Timing Alert");

        //Click the button
        alert.accept();

        //Verify the message in web page
        Assert.assertEquals(webDriver.findElement(By.id("confirm-demo")).getText(),"0");

    }


}
