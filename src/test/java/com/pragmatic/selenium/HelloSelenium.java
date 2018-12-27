package com.pragmatic.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSelenium {

    /**
     * First Selenium script
     */

    @Test
    public void tesHelloSelenium() throws InterruptedException {


        //Open an instance the target browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();//this will open the browser

        //Type the URL in address bar

        driver.get("http://com.pragmatic.selenium.hrm.pragmatictestlabs.com");

        //Wait till the page is loaded
        //This will be taken care by Selenium with get method

        //Do something
        //Type username

        WebElement txtUsername = driver.findElement(By.id("txtUsername"));
        txtUsername.clear();
        txtUsername.sendKeys("Admin");


        //Type password

        driver.findElement(By.name("txtPassword")).sendKeys("Ptl@#321");

        //Click login button

        driver.findElement(By.id("btnLogin")).click();

        //Verify the output (actual) with the expected
        //Check the Welcome message

        String welcomeMesssage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMesssage, "Welcome Admin");

        //Introduce a delay
        Thread.sleep(5000);


        //Close the browser
        driver.close();


    }
}
