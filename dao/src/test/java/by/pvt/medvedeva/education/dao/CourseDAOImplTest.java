package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Course;
import org.junit.Test;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;


public class CourseDAOImplTest {


    public CourseDAOImplTest() {

    }


    @Test
    public void getAllCoursesInfoTest() throws Exception {
        Course course = new Course();
        course.setAuditorium(5);
        course.setDuration(214);
      //  course.setIdTeacher(1);
        course.setName("ss");
        CourseDAOImpl dao = new CourseDAOImpl(H2ConnectionPool.getInstance());
        dao.create(course);
        ArrayList <Course> allCourses = dao.getAllCoursesInfo();
        assertFalse(allCourses.isEmpty());
    }

    @Test
    public void create() throws Exception {
        Course course = new Course();
        course.setAuditorium(504);
        course.setDuration(214);
      //  course.setIdTeacher(1);
        course.setName("KDHD");
        CourseDAOImpl dao = new CourseDAOImpl(H2ConnectionPool.getInstance());
        dao.create(course);
        assertFalse(dao.getAllCoursesInfo().isEmpty());

    }

}