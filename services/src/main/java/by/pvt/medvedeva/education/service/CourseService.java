package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.CourseDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class CourseService {
    private CourseDAOImpl courseDAO;
    private static CourseService instance;
    private static HibernateUtil util = HibernateUtil.getHibernateUtil();
    private static Session  session = util.getSession();
    private static Transaction transaction;

    /**
     * Singleton-fabric
     */
    public static CourseService getInstance() throws DAOException {
        if (instance == null) {
            instance = new CourseService();
        }
        return instance;
    }

    public CourseService() throws DAOException {
        courseDAO = CourseDAOImpl.getInstance();
    }

    public void create(Course course) throws DAOException {
        try {
            transaction = session.beginTransaction();
            courseDAO.create(course);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Transaction failed in create course method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create course method", e);
        }
        }

    public List<Course> getAll() throws DAOException  {
        List<Course> courses;
 //           session = util.getSession();
            transaction = session.beginTransaction();
            courses = courseDAO.getAll();
            transaction.commit();
        return courses;
    }
}
