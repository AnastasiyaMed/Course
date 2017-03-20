package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Course;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;

public class CourseDAOImplTest {

    private CourseDAOImpl courseDao;

    @Test
    public void getAllCoursesInfo() throws Exception {
        ArrayList<Course> allCourses = courseDao.getAllCoursesInfo();
        assertFalse(allCourses.isEmpty());
   }

    @Test
    public void addCourse() throws Exception {

    }

}