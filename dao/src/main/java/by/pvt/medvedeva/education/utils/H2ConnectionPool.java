package by.pvt.medvedeva.education.utils;

import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionPool implements ConnectionPool {
    private static H2ConnectionPool instance;
   private static final String DB_DRIVER = H2DbConfigurationManager.getProperty("driverClassName");
  // private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = H2DbConfigurationManager.getProperty("db.connection");
//private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = H2DbConfigurationManager.getProperty("user");
    private static final String DB_PASSWORD = H2DbConfigurationManager.getProperty("password");
//private static final String DB_USER = "as";
  //  private static final String DB_PASSWORD = "";

    public static H2ConnectionPool getInstance() throws SQLException {
        if(instance == null) {
            instance = new H2ConnectionPool();
        }
        return instance;
    }

//    public Properties getConnectProperties ()  {
//
//        String propFileName = "H2Dbconnection.properties";
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//        Properties property = new Properties();
//        try {
//            property.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return property;
//    }


    private H2ConnectionPool() throws SQLException {
        try (Connection c = getConnect()) {
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_COURSE_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("INSERT_INTO_COURSE_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_STUDENT_TABLE_SQL"));
            c.createStatement().executeUpdate(H2DbSQLManager.getProperty("INSERT_INTO_STUDENT_TABLE_SQL"));
            c.createStatement().executeUpdate(H2DbSQLManager.getProperty("CREATE_STUDENT_HAS_COURSE_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_TEACHER_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("INSERT_INTO_TEACHER_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("CREATE_USER_TABLE_SQL"));
            c.createStatement().execute(H2DbSQLManager.getProperty("INSERT_INTO_USER_TABLE_SQL"));
    }
    }



    @Override
    public Connection getConnect() throws SQLException {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }



}
