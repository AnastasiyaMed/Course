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
 * @author Anastasiya Medvedeva
 */
@ContextConfiguration("/context-dao-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
public class UserDAOImplTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void getUserByLoginTest() throws Exception {
        User expected = new User(null, "Test", "User", "login", "password", null, null);
        userDAO.create(expected);
        User actual = userDAO.getByLogin(expected.getLogin());
        Assert.assertEquals("Not valid", expected, actual);
    }
}
