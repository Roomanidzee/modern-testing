package com.romanidze.seleniumtesting.easy.real_talk.base;

import com.romanidze.seleniumtesting.easy.real_talk.manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * 02.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class HelperBase {

    private ApplicationManager manager;
    private WebDriver webDriver;

    public HelperBase(ApplicationManager manager){

        this.manager = manager;
        this.webDriver = manager.getWebDriver();

    }

    public boolean isElementPresent(By by){

        try{
            this.webDriver.findElement(by);
        }catch(NoSuchElementException ex){
            return false;
        }

        return true;

    }

}
