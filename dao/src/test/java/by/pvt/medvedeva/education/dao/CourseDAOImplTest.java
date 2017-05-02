package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Medvedeva Anastasiya
 */
@ContextConfiguration("/context-dao-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
public class CourseDAOImplTest {
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private TeacherDAO teacherDAO;


    /**
     * @throws Exception
     */
    @Test
    public void getAllTest() throws Exception {
        List <Course> courses;
        Course course = new Course();
        Teacher teacher = new Teacher(null, "ff", "ff", "ff", "ff", 2);
        course.setAuditorium(5);
        course.setDuration(214);
        course.setTeacher(teacher);
        course.setName("ss");
        teacherDAO.create(teacher);
        courseDAO.create(course);
        courses = courseDAO.getAll();
        Assert.assertEquals("don't equals", 1, courses.size());
    }

//    /**
//     * @throws Exception
//     */
//    @Test
//    public void createTest() throws Exception {
//        List <Course> courses;
//        session = util.getSession();
//        transaction = session.beginTransaction();
//        Teacher teacher = new Teacher(null, "ff", "ff", "winer", "ff", 2);
//        session.saveOrUpdate(teacher);
//        teacher = (Teacher) session.createCriteria(Teacher.class)
//                .add(Restrictions.like("login", "winer"))
//                .uniqueResult();
//        Course course = new Course();
//        course.setTeacher(teacher);
//        course.setAuditorium(234);
//        course.setDuration(35);
//        course.setName("dd");
//        dao.create(course);
//        Criteria criteria = session.createCriteria(Course.class);
//        courses = criteria.list();
//        transaction.commit();
//        Assert.assertNotEquals("don't equals", 0, courses.size());
//    }


}