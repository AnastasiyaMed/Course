package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/context-dao-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
public class CourseDAOImplTest {
    @Autowired
    private CourseDAO courseDAO;

    @Test
    public void getCourseByPage() throws Exception {
        Course c1 = new Course(null, "asd", 12, 23, null);
        Course c2 = new Course(null, "fde", 13, 43, null);
        Course c3 = new Course(null, "dwc", 14, 13, null);
        Course c4 = new Course(null, "fwa", 15, 33, null);
        courseDAO.create(c1);
        courseDAO.create(c2);
        courseDAO.create(c3);
        courseDAO.create(c4);

            int expected = 3;
            int actual = courseDAO.getCourseByPage(0, 3).size();
            Assert.assertTrue("Not equals", actual <= expected);
        }



    @Test
    public void getCoursesCount() throws Exception {
        Course c1 = new Course(null, "egs", 41, 13, null);
        Course c2 = new Course(null, "jht5", 25, 451, null);
        Course c3 = new Course(null, "hw", 14, 63, null);
        courseDAO.create(c1);
        courseDAO.create(c2);
        courseDAO.create(c3);
        int actual = courseDAO.getCoursesCount();
        Assert.assertEquals("Not equal", 3, actual);
    }

}