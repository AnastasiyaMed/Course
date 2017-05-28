package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.RoleDAO;
import by.pvt.medvedeva.education.entity.Role;
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
public class RoleDAOImplTest {

    @Autowired
    private RoleDAO roleDAO;

    @Test
    public void createRoleTest() throws Exception {
        Role expected = new Role(null, "Role name");
        roleDAO.create(expected);
        Role actual = roleDAO.getById(expected.getId());
        Assert.assertEquals("Not valid", expected, actual);
    }

    @Test
    public void updateRoleTest() throws Exception {
        Role expected = new Role(null, "Role name");
        roleDAO.create(expected);
        expected.setName("New name");
        roleDAO.update(expected);
        Role actual = roleDAO.getById(expected.getId());
        Assert.assertEquals("Not valid", expected, actual);
    }

    @Test
    public void deleteRoleTest() throws Exception {
        Role expected = new Role(null, "Role name");
        roleDAO.create(expected);
        roleDAO.delete(expected.getId());
        Role actual = roleDAO.getById(expected.getId());
        Assert.assertTrue("Not valid", actual == null);
    }

    @Test
    public void getAllRolesTest() throws Exception {
        int expectedCount = roleDAO.getAll().size();
        Role role = new Role(null, "Role name");
        roleDAO.create(role);
        int actualCount = roleDAO.getAll().size();
        Assert.assertEquals("Not valid", expectedCount + 1, actualCount);
    }

}
