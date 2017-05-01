package by.pvt.medvedeva.education.resource;

import java.util.ResourceBundle;
/**
 * @author Medvedeva Anastasiya
 */
public class ConfigurationManager {
  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

  // класс извлекает информацию из файла config. properties
  private ConfigurationManager() {
  }

  /**
   *
   * @param key
   * @return property
   */
  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}