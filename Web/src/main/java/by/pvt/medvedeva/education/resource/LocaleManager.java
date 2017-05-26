package by.pvt.medvedeva.education.resource;

import java.util.ResourceBundle;

/**
 * @author Medvedeva Anastasiya
 */
public class LocaleManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("locale");

    // класс извлекает информацию из файла locale. properties
    private LocaleManager() {
    }

    /**
     * @param key
     * @return property
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
