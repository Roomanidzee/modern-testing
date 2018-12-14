package com.romanidze.seleniumtesting.easy.real_talk.tests;

import com.romanidze.seleniumtesting.easy.real_talk.base.TestBase;
import com.romanidze.seleniumtesting.easy.real_talk.dto.LoginDTO;
import com.romanidze.seleniumtesting.easy.real_talk.helpers.LoginHelper;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 23.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends TestBase {

    private LoginDTO loginDTO;

    @Test
    public void testGoodCredentials(){

        LoginHelper loginHelper = manager.getLoginHelper();

        this.loginDTO = LoginDTO.builder()
                                .login("ваш_логин")
                                .password("ваш_пароль")
                                .build();

        loginHelper.setLoginDTO(this.loginDTO);
        loginHelper.login();
        Assert.assertEquals("Facebook – log in or sign up", manager.getWebDriver().getTitle());
    }

    @Test
    public void testNotGoodCredentials(){

        LoginHelper loginHelper = manager.getLoginHelper();

        this.loginDTO = LoginDTO.builder()
                                .login("ничего")
                                .password("ничего")
                                .build();

        loginHelper.setLoginDTO(this.loginDTO);
        loginHelper.login();
        Assert.assertNotEquals("Facebook", manager.getWebDriver().getTitle());

    }

}
