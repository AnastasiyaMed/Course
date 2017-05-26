package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Service
@Log4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    private CourseDAO courseDAO;

    @Autowired
    protected CourseServiceImpl(CourseDAO courseDAO) {
        super(courseDAO);
        this.courseDAO = courseDAO;
    }

    /**
     * @param course
     * @return
     * @throws DAOException
     */
    @Override
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

//    public List <Course> getCoursesByPage(int pageNumber, int pageCapacity) throws DAOException {
//        int pageOffset = pageCapacity * pageNumber - pageCapacity;
//        List <Course> courses;
//        try {
//            session = util.getSession();
//            courses = courseDAO.getCoursesByPage(pageOffset, pageCapacity);
//        } catch (DAOException e) {
//            transaction.rollback();
//            throw new DAOException(CourseServiceImpl.class, "Transaction failed in getCoursesByPage method", e);
//        }
//        if (courses.size() == 0) {
//            Course course = new Course(null, "no items", 0, 0, null);
//            courses.add(course);
//        }
//        return courses;
//    }
}
