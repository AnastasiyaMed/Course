package by.pvt.medvedeva.education.utils;

import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Anastasiya Medvedeva
 */
public class H2ConnectionPool implements ConnectionPool {
    private static H2ConnectionPool instance;
    private static final String DB_DRIVER = H2DbConfigurationManager.getProperty("driverClassName");
    private static final String DB_CONNECTION = H2DbConfigurationManager.getProperty("db.connection");
    private static final String DB_USER = H2DbConfigurationManager.getProperty("user");
    private static final String DB_PASSWORD = H2DbConfigurationManager.getProperty("password");

    /**
     * @return
     * @throws SQLException
     */
    public static H2ConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            instance = new H2ConnectionPool();
        }
        return instance;
    }

    /**
     * no param
     */
    private H2ConnectionPool() {
    }

    /**
     * @return connection
     * @throws SQLException
     */
    @Override
    public Connection getConnect() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                DB_PASSWORD);

        return connection;
    }


}
