package com.romanidze.seleniumtesting.easy.real_talk.helpers;

import com.romanidze.seleniumtesting.easy.real_talk.base.HelperBase;
import com.romanidze.seleniumtesting.easy.real_talk.manager.ApplicationManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;

/**
 * 02.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class StatusHelper extends HelperBase {

    private WebDriver webDriver;
    private String message;

    public StatusHelper(ApplicationManager manager) {
        super(manager);
        this.webDriver = manager.getWebDriver();
    }

    public void createStatus(String message){

        this.webDriver.findElement(By.xpath("//textarea[@name='xhpc_message']")).sendKeys(message);

        this.webDriver.findElement(By.xpath("//button[contains(.,'Поделиться')]")).click();

    }

    public void deleteStatus(){

        final String profileURL = this.webDriver.findElement(By.tagName("a")).getAttribute("href");
        final String profileName = profileURL.substring(25);

        Assert.assertNotNull(profileName);

        final String activityLink = "http://www.facebook.com/{0}/allactivity?privacy_source=activity_log&log_filter=cluster11";
        String resultLink =  MessageFormat.format(activityLink, profileName);

        this.webDriver.get(resultLink);

        WebElement buttonElement = this.webDriver.findElement(By.tagName("a")).findElement(By.name("Highlighted on Timeline"));

        this.webDriver.findElement(By.id(buttonElement.getCssValue("id"))).click();
        this.webDriver.findElement(By.linkText("Delete")).click();

    }

}
