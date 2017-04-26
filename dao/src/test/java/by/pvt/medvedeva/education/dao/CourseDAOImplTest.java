package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CourseDAOImplTest {
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session;
    private static Transaction transaction;
    CourseDAOImpl dao = new CourseDAOImpl(H2ConnectionPool.getInstance());

    public CourseDAOImplTest() throws SQLException {

    }


    @Test
    public void getAllTest() throws Exception {
        List <Course> courses;
        Course course = new Course();
        Teacher teacher = new Teacher(null, "ff", "ff", "ff", "ff", 2);
        course.setAuditorium(5);
        course.setDuration(214);
        course.setTeacher(teacher);
        course.setName("ss");
        session = util.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(teacher);
        session.saveOrUpdate(course);
        courses = dao.getAll();
        transaction.commit();
        Assert.assertEquals("don't equals", 1, courses.size());

    }

    @Test
    public void createTest() throws Exception {
        List <Course> courses;
        Course course = new Course();
        Teacher teacher = new Teacher(null, "ff", "ff", "ff", "ff", 2);
        course.setAuditorium(5);
        course.setDuration(214);
        course.setTeacher(teacher);
        course.setName("ss");
        session = util.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(teacher);
        session.saveOrUpdate(course);
        courses = dao.getAll();
        transaction.commit();
        Assert.assertEquals("don't equals", "ss", courses.get(0).getName());
    }




}