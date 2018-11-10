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

public class StatusHelper extends HelperBase {

    private WebDriver webDriver;
    private String message;

    public StatusHelper(ApplicationManager manager, String message) {
        super(manager);
        this.webDriver = manager.getWebDriver();
        this.message = message;
    }

    public void createStatus(){

        this.webDriver.findElement(By.xpath("//textarea[@name='xhpc_message']")).sendKeys(this.message);

        this.webDriver.findElement(By.xpath("//button[contains(.,'Share')]")).click();

    }

}
