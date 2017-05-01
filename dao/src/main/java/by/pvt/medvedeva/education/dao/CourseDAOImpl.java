package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;

import java.sql.SQLException;
import java.util.List;

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


    /**
     *  page big query with parameters
     * @param pageOffset   row offset
     * @param pageCapacity row limit
     * @return list of course
     * @throws DAOException custom exception
     */
    public List<Course> getCoursesByPage(int pageOffset, int pageCapacity) throws DAOException {
        try {
            session = util.getSession();
            criteria = session.createCriteria(Course.class);
            // Pagination
            criteria.setMaxResults(pageCapacity);
            criteria.setFirstResult(pageOffset);
            // Sort order
            criteria.addOrder(Order.desc("duration"));
            List<Course> courses = (List<Course>) criteria.list();
            for (Course c : courses) { int i = c.getAuditorium(); }
            return courses;
        } catch (HibernateException e) {
            throw new DAOException(CourseDAOImpl.class, "Fatal error in pagination method", e);
        }
    }


}
