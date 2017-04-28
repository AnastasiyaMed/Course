package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class UserDAOImplTest {
    private UserDAOImpl dao = new UserDAOImpl(H2ConnectionPool.getInstance());
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session;
    private static Transaction transaction;


    public UserDAOImplTest() throws SQLException {
    }

    @Test
    public void createTest() throws Exception {
        User user = new User();
        user.setLogin("hut");
        user.setName("John");
        user.setSurname("Sinicin");
        user.setPassword("111111");
       // user.setRole(0);
        session = util.getSession();
        transaction = session.beginTransaction();
        dao.create(user);
        User userTest = (User) session.createCriteria(User.class)
                .add(Restrictions.like("login", "tim"))
                .uniqueResult();
        transaction.commit();
        Assert.assertEquals("Ошибка добавления студента", "tim", userTest.getLogin());
    }


    @Test
    public void getByLoginTest() throws Exception {
        User user = new User(null, "w", "w", "c", "w", 0);
        session = util.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        User userTest = dao.getByLogin(user.getLogin());
        Assert.assertEquals("Ошибка чтения пользователя из базы", "c", userTest.getLogin());
    }

}