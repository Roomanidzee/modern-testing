package com.romanidze.seleniumtesting.hardertests.secondhard.tests;

import com.romanidze.seleniumtesting.hardertests.secondhard.base.TestBase;
import org.junit.Test;

/**
 * 10.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class StatusTest extends TestBase {

    @Test
    public void testPostStatus(){
        manager.getStatusHelper().createStatus();
    }

}
