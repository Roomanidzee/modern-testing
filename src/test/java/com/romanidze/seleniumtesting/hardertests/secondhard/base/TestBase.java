package com.romanidze.seleniumtesting.hardertests.secondhard.base;

import com.romanidze.seleniumtesting.hardertests.secondhard.dto.LoginDTO;
import com.romanidze.seleniumtesting.hardertests.secondhard.manager.ApplicationManager;

import org.junit.Before;

/**
 * 02.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class TestBase {

    protected ApplicationManager manager = new ApplicationManager();

    @Before
    public void setUp(){

        LoginDTO loginDTO = LoginDTO.builder()
                                    .login("ваш_логин")
                                    .password("ваш_пароль")
                                    .build();

        manager.getNavigationHelper().openMainPage();
        manager.getLoginHelper().login();

    }

}
