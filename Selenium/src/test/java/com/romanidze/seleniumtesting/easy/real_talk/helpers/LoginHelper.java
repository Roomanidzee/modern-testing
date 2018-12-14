package com.romanidze.seleniumtesting.easy.real_talk.helpers;

import com.romanidze.seleniumtesting.easy.real_talk.base.HelperBase;
import com.romanidze.seleniumtesting.easy.real_talk.dto.LoginDTO;
import com.romanidze.seleniumtesting.easy.real_talk.manager.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public LoginHelper(ApplicationManager manager) {
        super(manager);
        this.webDriver = manager.getWebDriver();
        this.wait = manager.getWait();
    }

    public void login(){

        this.webDriver.findElement(By.id("email")).sendKeys(this.loginDTO.getLogin());
        this.webDriver.findElement(By.id("pass")).sendKeys(this.loginDTO.getPassword());

    }

}
