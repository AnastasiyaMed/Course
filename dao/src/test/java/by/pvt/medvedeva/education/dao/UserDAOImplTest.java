package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class UserDAOImplTest {
    private UserDAOImpl dao = new UserDAOImpl(H2ConnectionPool.getInstance());

    public UserDAOImplTest() throws SQLException {
    }

    @Test
    public void createTest() throws Exception {
    User user = new User(0, "d", "s", "c", "c", 1);
    dao.create(user);
    User userTest = dao.getUserByLogin(user.getLogin());
        Assert.assertEquals("Ошибка записи пользователя ", "d", userTest.getName());
    }

    @Test
    public void getUserByLoginTest() throws Exception {
        User user = new User(0, "d", "s", "c", "c", 0);
        dao.create(user);
        User userTest = dao.getUserByLogin(user.getLogin());
        Assert.assertEquals("Ошибка чтения пользователя из базы", "c", userTest.getLogin());
    }

    @Test
    public void checkLoginTest() throws Exception {
        User user = new User(0, "d", "s", "c", "c", 0);
        dao.create(user);
        Assert.assertTrue(dao.CheckLogin(user.getLogin()));
    }

}