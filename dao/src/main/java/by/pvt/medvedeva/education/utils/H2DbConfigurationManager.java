package by.pvt.medvedeva.education.utils;

import java.util.ResourceBundle;

/**
 * @author Anastasiya Medvedeva
 */
public class H2DbConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("H2Dbconnection");

    /**
     * no param
     */
    private H2DbConfigurationManager() {
    }

    /**
     * @param key
     * @return property
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
