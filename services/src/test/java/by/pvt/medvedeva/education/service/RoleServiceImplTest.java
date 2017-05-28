package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.entity.Role;
import by.pvt.medvedeva.education.service.interfaces.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Anastasiya Medvedeva
 */
@ContextConfiguration("/service-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplTest {
    
    @Autowired
    private RoleService roleService;

    @Test
    public void createRoleTest() throws Exception {
        Role expected = new Role(null, "Role name");
        roleService.create(expected);
        Role actual = roleService.getById(expected.getId());
        Assert.assertEquals("Not valid", expected, actual);
    }

    @Test
    public void updateRoleTest() throws Exception {
        Role expected = new Role(null, "Rolename");
        roleService.create(expected);
        expected.setName("Newname");
        roleService.update(expected);
        Role actual = roleService.getById(expected.getId());
        Assert.assertEquals("Not valid", expected, actual);
    }

    @Test
    public void deleteRoleTest() throws Exception {
        Role expected = new Role(null, "Rolename");
        roleService.create(expected);
        roleService.delete(expected.getId());
        Role actual = roleService.getById(expected.getId());
        Assert.assertTrue("Not valid", actual == null);
    }

    @Test
    public void getAllRolesTest() throws Exception {
        int expectedCount = roleService.getAll().size();
        Role role = new Role(null, "Rolename");
        roleService.create(role);
        int actualCount = roleService.getAll().size();
        Assert.assertEquals("Not valid", expectedCount + 1, actualCount);
    }
}
