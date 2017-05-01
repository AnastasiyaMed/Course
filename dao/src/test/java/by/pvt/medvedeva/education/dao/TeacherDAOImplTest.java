package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author Medvedeva Anastasiya
 */
public class TeacherDAOImplTest {
    private TeacherDAOImpl dao = new TeacherDAOImpl(H2ConnectionPool.getInstance());
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session;
    private static Transaction transaction;

    /**
     * @throws SQLException
     */
    public TeacherDAOImplTest() throws SQLException {
    }

    /**
     * @throws Exception
     */
    @Test
    public void initTeacherTest() throws Exception {
        User user = new User(0, "w", "w", "return", "w", 2);
        Teacher teacher = dao.initTeacher(user);
        Assert.assertEquals("Ошибка инициализации преподавателя", "return", teacher.getLogin());
    }

    /**
     * @throws Exception
     */
    @Test
    public void getByIdTest() throws Exception {
        Teacher teacher = new Teacher(null, "w", "w", "w", "w", 2);
        session = util.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(teacher);
        Teacher teacher1 = (Teacher) session.createCriteria(Teacher.class)
                .add(Restrictions.like("login", "w"))
                .uniqueResult();
        Teacher teacherTest = dao.getById(teacher1.getIdUser());
        transaction.commit();
        Assert.assertNotNull("преподаватель не найден в базе", teacherTest);
    }

    /**
     * @throws Exception
     */
    @Test
    public void createTest() throws Exception {
        User user = new User();
        user.setLogin("tim");
        user.setName("John");
        user.setSurname("Sinicin");
        user.setPassword("111111");
        user.setRole(2);
        Teacher teacher = dao.initTeacher(user);
        session = util.getSession();
        transaction = session.beginTransaction();
        dao.create(teacher);
        Teacher teacherTest = (Teacher) session.createCriteria(Teacher.class)
                .add(Restrictions.like("login", "tim"))
                .uniqueResult();
        transaction.commit();
        Assert.assertEquals("Ошибка добавления преподавателя", "tim", teacherTest.getLogin());
    }
}