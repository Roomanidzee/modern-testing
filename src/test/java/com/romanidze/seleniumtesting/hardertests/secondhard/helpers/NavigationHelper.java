package com.romanidze.seleniumtesting.hardertests.secondhard.helpers;

import com.romanidze.seleniumtesting.hardertests.secondhard.base.HelperBase;
import com.romanidze.seleniumtesting.hardertests.secondhard.manager.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 02.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class NavigationHelper extends HelperBase {

    private String baseURL;
    private WebDriver webDriver;

    public NavigationHelper(ApplicationManager manager, String baseURL) {
        super(manager);
        this.baseURL = baseURL;
        this.webDriver = manager.getWebDriver();
    }

    public void openMainPage(){

        this.webDriver.get(this.baseURL);

    }

    public void openStatusWindow(){

        this.webDriver.findElement(By.xpath("//textarea[@name='xhpc_message']")).click();

    }

}
