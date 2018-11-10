package com.romanidze.seleniumtesting.hardertests.secondhard.helpers;

import com.romanidze.seleniumtesting.hardertests.secondhard.base.HelperBase;
import com.romanidze.seleniumtesting.hardertests.secondhard.dto.LoginDTO;
import com.romanidze.seleniumtesting.hardertests.secondhard.manager.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 02.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class LoginHelper extends HelperBase {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private LoginDTO loginDTO;

    public LoginHelper(ApplicationManager manager, WebDriverWait wait) {
        super(manager);
        this.webDriver = manager.getWebDriver();
        this.wait = wait;
        this.loginDTO = LoginDTO.builder()
                                .login("ваш_логин")
                                .password("ваш_пароль")
                                .build();
    }

    public void login(){

        this.webDriver.findElement(By.id("email")).sendKeys(this.loginDTO.getLogin());
        this.webDriver.findElement(By.id("pass")).sendKeys(this.loginDTO.getPassword());
        this.webDriver.findElement(By.id("loginbutton")).click();
        this.wait.until(ExpectedConditions.titleContains("Facebook"));

    }

}
