package by.pvt.medvedeva.education.utils;

import java.util.ResourceBundle;

public class H2DbConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("H2Dbconnection");

    private H2DbConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
