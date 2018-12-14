package com.romanidze.seleniumtesting.easy.easy.tests;

import com.romanidze.seleniumtesting.easy.easy.base.TestCase;
import com.romanidze.seleniumtesting.easy.easy.dto.LoginDTO;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * 26.10.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatusTestCase extends TestCase {

    private LoginDTO loginDTO;
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void setUp(){

        this.loginDTO = LoginDTO.builder()
                                .siteName("https://www.facebook.com")
                                .login("ваш_логин")
                                .password("ваш_пароль")
                                .build();

        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 500);

    }

    @Override
    @Test
    public void loginInSite(){

        this.webDriver.get(this.loginDTO.getSiteName());
        this.webDriver.findElement(By.id("email")).sendKeys(this.loginDTO.getLogin());
        this.webDriver.findElement(By.id("pass")).sendKeys(this.loginDTO.getPassword());
        this.webDriver.findElement(By.id("loginbutton")).click();
        this.wait.until(ExpectedConditions.titleContains("Facebook"));

        performAction();

    }

    @Override
    public void performAction() {

        this.webDriver.findElement(By.xpath("//textarea[@name='xhpc_message']")).sendKeys("Ураа, работает");

        this.webDriver.findElement(By.xpath("//button[contains(.,'Share')]")).click();

    }

}
