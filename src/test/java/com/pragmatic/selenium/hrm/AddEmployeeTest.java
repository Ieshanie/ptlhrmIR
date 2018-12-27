package com.pragmatic.selenium.hrm;

import com.github.javafaker.Faker;
import com.sun.org.apache.xpath.internal.SourceTreeManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddEmployeeTest {

    WebDriver driver;
    public static final String BASE_URL = ("http://hrm.pragmatictestlabs.com");
    private Faker faker;
    String firstName;
    /*String middleName = faker.name().nameWithMiddle();
    String lastName=faker.name().lastName();
    String strEmployeeId;*/

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        faker = new Faker();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        firstName = "User" + faker.name().firstName();
    }


    @AfterMethod
    public void afterMethod() {
        driver.close();

    }

    @Test

    public void testAddEmployee() throws InterruptedException {
        String firstName = "User" + faker.name().firstName();
        String middleName = faker.name().nameWithMiddle();
        String lastName = faker.name().lastName();
        String passWord = "Ptl@#321";



        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("middleName")).sendKeys(middleName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);


        //EmployeeId
        String strEmployeeId = driver.findElement(By.id("employeeId")).getAttribute("value");
        Assert.assertTrue(strEmployeeId.length() == 4);


        //File Upload

        driver.findElement(By.id("photofile")).sendKeys("D:\\Selenium\\seleniumg5\\testData\\Pics\\SL-flag.jpg");

        //Click Check box

        if (driver.findElement(By.id("chkLogin")).isSelected() == false) {
            driver.findElement(By.id("chkLogin")).click();
        }

        Select lstStatus = (new Select(driver.findElement(By.id("status"))));
        lstStatus.selectByIndex(1);
        //lstStatus.selectByValue("Enabled");
        // lstStatus.selectByVisibleText("Enabled");

        //USer name
        driver.findElement(By.id("user_name")).sendKeys(firstName);

        //Type password
        driver.findElement(By.id("user_password")).sendKeys(passWord);

        //Reenter Password
        driver.findElement(By.id("re_password")).sendKeys(passWord);

        //Click Save Button
        driver.findElement(By.id("btnSave")).click();

        //Verify login user
        Thread.sleep(5000);
        String strFirstname = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
        Assert.assertEquals(strFirstname, firstName);

        String strMiddlename = driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value");
        Assert.assertEquals(strMiddlename, middleName);

        String strLastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
        Assert.assertEquals(strLastName, lastName);

        String strpersonalEmployeeId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
        Assert.assertEquals(strpersonalEmployeeId, strEmployeeId);


        //Logout
        WebElement logOut = driver.findElement(By.id("welcome"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Logout")).click();
        //System.out.println("Logout");


        //Verify new user login
        driver.findElement(By.id("txtUsername")).sendKeys(firstName);
        driver.findElement(By.id("txtPassword")).sendKeys(passWord);
        driver.findElement(By.id("btnLogin")).click();

        String loginUser = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(loginUser, "Account disabled");



    }


}
