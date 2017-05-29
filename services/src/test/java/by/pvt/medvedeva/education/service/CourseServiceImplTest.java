package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.service.interfaces.CourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/service-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CourseServiceImplTest {
    @Autowired
    CourseService courseService;

    @Test
    public void getCoursesByPage() throws Exception {
        Course c1 = new Course(null, "asd", 12, 23, null);
        Course c2 = new Course(null, "fde", 13, 43, null);
        Course c3 = new Course(null, "dwc", 14, 13, null);
        Course c4 = new Course(null, "fwa", 15, 33, null);
        courseService.create(c1);
        courseService.create(c2);
        courseService.create(c3);
        courseService.create(c4);

        int expected = 3;
        int actual = courseService.getCoursesByPage(0, 3).size();
        Assert.assertTrue("Not equals", actual <= expected);
    }


    @Test
    public void getCoursesCount() throws Exception {
        Course c1 = new Course(null, "sjs", 41, 13, null);
        Course c2 = new Course(null, "jht5", 25, 451, null);
        Course c3 = new Course(null, "hw", 14, 63, null);
        courseService.create(c1);
        courseService.create(c2);
        courseService.create(c3);
        int actual =  courseService.getCoursesCount();
        Assert.assertEquals("Not equal", 3, actual);
    }

}