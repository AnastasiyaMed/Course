package by.pvt.medvedeva.education.dao.interfacesDAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnect() throws SQLException;



}
