package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CourseDAOImplTest {
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session;
    private Transaction transaction;
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
        session = util.getSession();
        transaction = session.beginTransaction();
        Teacher teacher = new Teacher(null, "ff", "ff", "winer", "ff", 2);
        session.saveOrUpdate(teacher);
        teacher = (Teacher) session.createCriteria(Teacher.class)
                .add(Restrictions.like("login", "winer"))
                .uniqueResult();
        Course course = new Course();
        course.setTeacher(teacher);
        course.setAuditorium(234);
        course.setDuration(35);
        course.setName("dd");
        dao.create(course);
        Criteria criteria = session.createCriteria(Course.class);
        courses =  criteria.list();
        transaction.commit();
        Assert.assertNotEquals("don't equals", 0, courses.size());
    }


}