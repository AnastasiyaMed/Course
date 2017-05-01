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
      //      getTransaction();
            courseDAO.create(course);
      //      commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in create course method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create course method", e);
        }
    }

    public List <Course> getAll() throws DAOException {
        List <Course> courses;
        session = util.getSession();
     //   getTransaction();
        courses = courseDAO.getAll();
    //    commitTransaction();
        return courses;
    }

    public boolean checkCourseIsExist(Course course) throws DAOException {
        boolean checkCourse = false;
        List <Course> courses = getAll();
        for (Course c : courses) {
            if ((course.getName().equals(c.getName()))
                    && (course.getAuditorium() == c.getAuditorium())
                    && (course.getDuration() == c.getDuration())
                    && (course.getTeacher().equals(c.getTeacher()))) {
                checkCourse = true;
                return checkCourse;
            } else {
                checkCourse = false;
            }
        }
        return checkCourse;
    }
}
