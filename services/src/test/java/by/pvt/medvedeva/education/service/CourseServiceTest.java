package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.CourseDAOImpl;
import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
public class CourseServiceTest {
    CourseService service = CourseService.getInstance();
    Teacher teacher;

    /**
     * @throws DAOException
     */
    public CourseServiceTest() throws DAOException {
    }

    /**
     * @throws Exception
     */
    @Test
    public void CourseServiceTest() throws Exception {
        List <Course> courses;
        Course course = new Course(null, "Psihology", 65, 414, teacher);
       /*
       * create() Method
       * */
        service.create(course);
          /*
       * getAll() Method
       * */
        courses = service.getAll();
        Course courseTest = new Course();
        for (Course c : courses) {
            if (c.getName().equals(course.getName())) {
                courseTest = c;
            }
        }
        CourseDAOImpl.getInstance().delete(course.getCourseId());
        Assert.assertEquals("Дисциплина не совпадает", course, courseTest);
    }


}