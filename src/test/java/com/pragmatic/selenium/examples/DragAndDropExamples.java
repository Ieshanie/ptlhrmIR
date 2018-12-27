package com.pragmatic.selenium.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class DragAndDropExamples {

    @Test
    public void testDragAndDrop() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("http://demosite.pragmatictestlabs.com/Droppable.html");

        WebElement sourceElement = webDriver.findElement(By.id("draggableview"));
        WebElement targetElement = webDriver.findElement(By.id("droppableview"));


        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(sourceElement, targetElement)
                .build()
                .perform();

        String message = webDriver.findElement(By.id("droppableview")).getText();
        Assert.assertEquals(message, "Dropped!");

    }
}
