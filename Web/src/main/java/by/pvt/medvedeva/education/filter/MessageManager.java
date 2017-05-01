package by.pvt.medvedeva.education.filter;

import java.util.ResourceBundle;

/**
 * @author Anastasiya Medvedeva
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    // класс извлекает информацию из файла messages. properties
    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}