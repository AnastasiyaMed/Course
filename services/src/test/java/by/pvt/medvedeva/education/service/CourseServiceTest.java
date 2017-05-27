package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@ContextConfiguration("/service-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CourseServiceTest {
    @Autowired
   private CourseService courseService;

 private  Teacher teacher;


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
        courseService.create(course);
          /*
       * getAll() Method
       * */
        courses = courseService.getAll();
        Course courseTest = new Course();
        for (Course c : courses) {
            if (c.getName().equals(course.getName())) {
                courseTest = c;
            }
        }
        courseService.delete(course.getCourseId());
        Assert.assertEquals("Дисциплина не совпадает", course, courseTest);
    }


}