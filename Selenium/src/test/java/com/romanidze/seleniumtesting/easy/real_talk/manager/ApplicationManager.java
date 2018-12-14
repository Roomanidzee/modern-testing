package com.romanidze.seleniumtesting.easy.real_talk.manager;

import com.romanidze.seleniumtesting.easy.real_talk.helpers.LoginHelper;
import com.romanidze.seleniumtesting.easy.real_talk.helpers.NavigationHelper;
import com.romanidze.seleniumtesting.easy.real_talk.helpers.StatusHelper;
import com.romanidze.seleniumtesting.easy.real_talk.tests.LoginTest;
import com.romanidze.seleniumtesting.easy.real_talk.tests.StatusTest;
import com.romanidze.seleniumtesting.easy.real_talk.utils.Settings;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * 02.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        StatusTest.class
})
public class ApplicationManager {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private StatusHelper statusHelper;

    public ApplicationManager(){

        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 500);

        this.navigationHelper = new NavigationHelper(this, Settings.getBasePath());
        this.loginHelper = new LoginHelper(this);
        this.statusHelper = new StatusHelper(this);

    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public StatusHelper getStatusHelper() {
        return statusHelper;
    }

}
