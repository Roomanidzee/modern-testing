package com.romanidze.seleniumtesting.easy.real_talk.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 30.11.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */

public class Settings {

    private static final String FILE_PATH = "src/test/resources/settings/settings.xml";

    private static String basePath;
    private static String login;
    private static String password;

    static{

        try {

            File file = new File(FILE_PATH);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            basePath = doc.getElementsByTagName("BaseUrl").item(0).getTextContent();
            login = doc.getElementsByTagName("Login").item(0).getTextContent();
            password = doc.getElementsByTagName("Password").item(0).getTextContent();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    public static String getBasePath() {
        return basePath;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

}
