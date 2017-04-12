package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import snaq.db.DBPoolDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/***
 *
 * @author Medvedeva Anastasiya
 *
 */
public class MySQLConnectionPool implements ConnectionPool {
    private static MySQLConnectionPool instance;


    /**
     * Singleton
     */
    public static MySQLConnectionPool getInstance() {
                if (instance == null) {
                instance = new MySQLConnectionPool();

                }
    return instance;
    }


     private Properties getConnectProperties ()  {

         String propFileName = "MySQL.properties";
         InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
         Properties property = new Properties();
         try {
             property.load(inputStream);
         } catch (IOException e) {
             e.printStackTrace();
         }

         return property;
     }


    @Override
    public Connection getConnect()  {
        Properties property = getConnectProperties ();
        DBPoolDataSource ds = new DBPoolDataSource();
        ds.setName(property.getProperty("name"));
        ds.setDriverClassName(property.getProperty("driverClassName"));
        ds.setUrl(property.getProperty("url"));
        ds.setUser(property.getProperty("user"));
        ds.setPassword(property.getProperty("password"));
        ds.setMinPool(2);
        ds.setMaxPool(10);
        ds.setMaxSize(100);
        ds.setIdleTimeout(7200);  // Specified in seconds.


        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
