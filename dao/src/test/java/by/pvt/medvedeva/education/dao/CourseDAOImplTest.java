//package by.pvt.medvedeva.education.dao;
//
//import by.pvt.medvedeva.education.entity.Course;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static junit.framework.TestCase.assertFalse;
//
//
//public class CourseDAOImplTest {
//
//
//    public CourseDAOImplTest() {
//
//    }
//
//
//
//    @Test
//    public void getAllCoursesInfoTest() throws Exception {
//        CourseDAOImpl courseDAO = new CourseDAOImpl();
//        Course course = new Course();
//        course.setAuditorium(504);
//        course.setDuration(214);
//        course.setIdTeacher(1);
//        course.setName("Gjkt");
//        courseDAO.addCourse(course);
//        ArrayList <Course> allCourses = courseDAO.getAllCoursesInfo();
//        assertFalse(allCourses.isEmpty());
//    }
//
//    @Test
//    public void addCourse() throws Exception {
//        CourseDAOImpl courseDAO = new CourseDAOImpl();
//        Course course = new Course();
//        course.setAuditorium(504);
//        course.setDuration(214);
//        course.setIdTeacher(1);
//        course.setName("KDHD");
//        courseDAO.addCourse(course);
//
//
//    }
//
//}