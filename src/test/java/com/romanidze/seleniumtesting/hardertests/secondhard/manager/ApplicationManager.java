package com.romanidze.seleniumtesting.hardertests.secondhard.manager;

import com.romanidze.seleniumtesting.hardertests.secondhard.helpers.LoginHelper;
import com.romanidze.seleniumtesting.hardertests.secondhard.helpers.NavigationHelper;
import com.romanidze.seleniumtesting.hardertests.secondhard.helpers.StatusHelper;

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
public class ApplicationManager {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private String baseURL;

    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private StatusHelper statusHelper;

    public ApplicationManager(){

        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.webDriver, 500);
        this.baseURL = "https://www.facebook.com";

        this.navigationHelper = new NavigationHelper(this, this.baseURL);
        this.loginHelper = new LoginHelper(this, this.wait);
        this.statusHelper = new StatusHelper(this, "Новая попытка, ураа");

    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getBaseURL() {
        return baseURL;
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
