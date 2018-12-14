package com.romanidze.seleniumtesting.easy.real_talk.tests;

import com.romanidze.seleniumtesting.easy.real_talk.base.AuthTestBase;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.openqa.selenium.By;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * 10.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(DataProviderRunner.class)
public class StatusTest extends AuthTestBase {

    private static final String TEST_DATA_PATH = "src/test/resources/test_data/status_data.xml";
    private static final Integer messagesLength = 7;

    @DataProvider
    public static Object[][] messageDataProvider(){

        File file = new File(TEST_DATA_PATH);

        Object[][] result = new Object[messagesLength][messagesLength];

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            NodeList statuses = doc.getElementsByTagName("message");

            if(statuses.getLength() != messagesLength){
                throw new IOException("Неправильно сконфигурирован файл со статусами");
            }

            IntStream.range(0, statuses.getLength()).forEachOrdered(i -> {

                Node status = statuses.item(i);

                if (status.getNodeType() != Node.TEXT_NODE) {
                    result[i] = new Object[]{status.getTextContent()};
                }

            });

        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Test
    @UseDataProvider("messageDataProvider")
    public void testPostStatus(String message){
        manager.getNavigationHelper().openStatusWindow();

        Assert.assertNotNull(manager.getWebDriver().findElement(By.xpath("//textarea[@name='xhpc_message']")).getLocation());

        manager.getStatusHelper().createStatus(message);
    }

    @Test
    public void testRemoveStatus(){

        Assert.assertNotNull(manager.getWebDriver().findElement(By.tagName("a")).getAttribute("href"));

        manager.getNavigationHelper().openStatusWindow();
        manager.getStatusHelper().deleteStatus();
    }

}
