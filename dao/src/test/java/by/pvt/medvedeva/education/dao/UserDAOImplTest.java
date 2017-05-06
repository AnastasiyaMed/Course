package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Medvedeva Anastasiya
 */
@ContextConfiguration("/context-dao-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
public class UserDAOImplTest {
    @Autowired
    private UserDAO userDAO;


    /**
     * @throws Exception
     */
    @Test
    public void createTest() throws Exception {
        User user = new User();
        user.setLogin("hut");
        user.setName("John");
        user.setSurname("Sinicin");
        user.setPassword("111111");
        userDAO.create(user);
        User userTest = userDAO.getByLogin(user.getLogin());
        Assert.assertEquals("Ошибка добавления пользователя", "hut", userTest.getLogin());
    }

    /**
     * @throws Exception
     */
    @Test
    public void getByLoginTest() throws Exception {
        User user = new User(null, "w", "w", "c", "w", 0);
        userDAO.create(user);
        User userTest = userDAO.getByLogin(user.getLogin());
        Assert.assertEquals("Ошибка чтения пользователя из базы", user.getLogin(), userTest.getLogin());
    }

    /**
     * @throws Exception
     */
    @Test
    public void deleteTest() throws Exception {
        User user = new User(null, "bg", "bg", "bg", "bg", 0);
        userDAO.create(user);
        userDAO.delete(user.getIdUser());
        User userTest = userDAO.getById(user.getIdUser());
        Assert.assertNull("Ошибка удаления пользователя из базы", userTest);
    }

}