package by.pvt.medvedeva.education.dao.interfacesDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public interface ConnectionPool {
    Connection getConnect(Properties property) throws SQLException;



}
