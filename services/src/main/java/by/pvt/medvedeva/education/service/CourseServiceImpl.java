package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
private final CourseDAO courseDAO;

    @Autowired
    protected CourseServiceImpl(CourseDAO courseDAO) {
        super(courseDAO);
        this.courseDAO = courseDAO;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Course> getCoursesByPage(int pageNumber, int pageCapacity) throws DAOException {
        int pageOffset = pageCapacity * pageNumber - pageCapacity;
        List<Course> courses;
        courses = courseDAO.getCourseByPage(pageOffset, pageCapacity);
        return courses;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCoursesCount() throws DAOException {
        return courseDAO.getCoursesCount();
    }
}
