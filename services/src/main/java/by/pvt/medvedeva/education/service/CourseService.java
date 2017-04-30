package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.CourseDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class CourseService extends AbstractService {
    private CourseDAOImpl courseDAO;
    private static CourseService instance;


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
            session = util.getSession();
            if (flag == true) {
                transaction = session.getTransaction();
            } else {
                transaction = session.beginTransaction();
                flag = true;
            }
            courseDAO.create(course);
            if (flag == false) {
                transaction.commit();
            }
        } catch (HibernateException e) {
            log.error("Transaction failed in create course method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create course method", e);
        }
    }

    public List <Course> getAll() throws DAOException {
        List <Course> courses;
        session = util.getSession();
        if (flag == false) {
            transaction = session.beginTransaction();
            flag = true;
        } else {
            transaction = session.getTransaction();
        }
        courses = courseDAO.getAll();
        if (flag == false) {
            transaction.commit();
        }
        return courses;
    }
}
