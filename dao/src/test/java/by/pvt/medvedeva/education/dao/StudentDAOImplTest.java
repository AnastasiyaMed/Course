package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class StudentDAOImplTest {
    private StudentDAOImpl dao = new StudentDAOImpl(H2ConnectionPool.getInstance());
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session;
    private static Transaction transaction;
    public StudentDAOImplTest() throws SQLException {

    }


    @Test
    public void initStudentTest() throws Exception {
        User user = new User();
        user.setLogin("vac");
        user.setName("Vasia");
        user.setSurname("Curicin");
        user.setPassword("111111");
        user.setRole(1);
        Student student = dao.initStudent(user, 2, 1.2, 123);
        Assert.assertEquals("Ошибка инициализации студента", "vac", student.getLogin());
    }

    @Test
    public void createTest() throws Exception {
        User user = new User();
        user.setLogin("vac");
        user.setName("Vasia");
        user.setSurname("Curicin");
        user.setPassword("111111");
        user.setRole(1);
        Student student = dao.initStudent(user, 3, 3.4, 342);
        session = util.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        Student studentTest = (Student) session.createCriteria(Student.class)
                .add(Restrictions.like("login", "vac"))
                .uniqueResult();
        transaction.commit();
       Assert.assertEquals("Ошибка добавления студента", "vac", studentTest.getLogin());
    }

}