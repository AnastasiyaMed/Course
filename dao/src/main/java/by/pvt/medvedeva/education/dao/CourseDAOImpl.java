package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;

import java.sql.SQLException;

/**
 * @author Anastasiya Medvedeva
 */

public class CourseDAOImpl extends AbstractDAO <Course> implements CourseDAO <Course> {
    private static CourseDAOImpl instance;

    /**
     * Singleton-fabric
     */
    public static CourseDAOImpl getInstance() throws DAOException {
        if (instance == null) {
            try {
                instance = new CourseDAOImpl(MySQLConnectionPool.getInstance());
            } catch (SQLException e) {
                throw new DAOException("Some trouble with connect to database", e);
            }
        }
        return instance;
    }

    /**
     *
     * @param connectionPool
     * @throws SQLException
     */
    CourseDAOImpl(ConnectionPool connectionPool) throws SQLException {
        super(Course.class);
        this.connectionPool = connectionPool;
    }

}
