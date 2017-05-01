package by.pvt.medvedeva.education.dao.interfacesDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Medvedeva Anastasiya
 *         <p>
 *         inerface for help to use two connection pools for different database
 */
public interface ConnectionPool {
    /**
     * @return
     * @throws SQLException
     */
    Connection getConnect() throws SQLException;


}
