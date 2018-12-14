package com.romanidze.seleniumtesting.easy.real_talk.base;

import com.romanidze.seleniumtesting.easy.real_talk.manager.ApplicationManager;

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
        manager.getNavigationHelper().openMainPage();
    }

}
