package com.romanidze.seleniumtesting.easy.real_talk.base;

import com.romanidze.seleniumtesting.easy.real_talk.dto.LoginDTO;

import com.romanidze.seleniumtesting.easy.real_talk.helpers.LoginHelper;
import com.romanidze.seleniumtesting.easy.real_talk.utils.Settings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * 23.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class AuthTestBase extends TestBase{

    protected LoginDTO loginDTO;

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    @Before
    @Override
    public void setUp() {
        super.setUp();

        this.loginDTO = LoginDTO.builder()
                                .login(Settings.getLogin())
                                .password(Settings.getPassword())
                                .build();

        LoginHelper loginHelper = manager.getLoginHelper();
        loginHelper.setLoginDTO(this.loginDTO);

        loginHelper.login();
        Assert.assertTrue(this.isLoggedIn());

        manager.getWebDriver().findElement(By.id("loginbutton")).click();
        manager.getWait().until(ExpectedConditions.titleContains("Facebook"));

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        manager.getWebDriver().findElement(By.xpath("//div[contains(@id,'userNavigationLabel')]")).click();

        Thread.sleep(3000);
        manager.getWebDriver().findElement(By.xpath("//span[@class='_54nh'][contains(.,'Log Out')]")).click();


    }

    private boolean isLoggedIn(){

        if(this.isLoggedIn(this.loginDTO.getLogin())){

            Assert.assertEquals("Facebook – log in or sign up", manager.getWebDriver().getTitle());
            return true;

        }

        return false;
    }

    private boolean isLoggedIn(String username){
        return !manager.getWebDriver().findElement(By.id("email")).getText().equals(username);
    }

}
