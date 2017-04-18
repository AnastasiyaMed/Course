package by.pvt.medvedeva.education.utils;

import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionPool implements ConnectionPool {
    private static H2ConnectionPool instance;
    private static final String DB_DRIVER = H2DbConfigurationManager.getProperty("driverClassName");
    private static final String DB_CONNECTION = H2DbConfigurationManager.getProperty("db.connection");
    private static final String DB_USER = H2DbConfigurationManager.getProperty("user");
    private static final String DB_PASSWORD = H2DbConfigurationManager.getProperty("password");


    public static H2ConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            instance = new H2ConnectionPool();
        }
        return instance;
    }


    private H2ConnectionPool() throws SQLException {
        try (Connection c = getConnect()) {
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_SCHEMA"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_USER_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_COURSE_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_STUDENT_TABLE_SQL"));
            c.createStatement().executeUpdate(H2DbSQLManager.getProperty("CREATE_STUDENT_HAS_COURSE_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_TEACHER_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("INSERT_INTO_TEACHER_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("INSERT_INTO_USER_TABLE_SQL"));
            c.createStatement().executeUpdate(H2DbSQLManager.getProperty("INSERT_INTO_STUDENT_TABLE_SQL"));
        }
    }


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
