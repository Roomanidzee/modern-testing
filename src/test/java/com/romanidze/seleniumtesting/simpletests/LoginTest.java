package com.romanidze.seleniumtesting.simpletests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 19.10.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class LoginTest {

    private String siteName = "https://www.facebook.com";
    private String email = "ваш_логин";
    private String password = "ваш_пароль";
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 20);
    }

    @Test
    public void testLogin(){

        this.webDriver.get(this.siteName);
        this.webDriver.findElement(By.id("email")).sendKeys(this.email);
        this.webDriver.findElement(By.id("pass")).sendKeys(this.password);
        this.webDriver.findElement(By.id("loginbutton")).click();
        wait.until(ExpectedConditions.titleContains("home"));

    }

}
