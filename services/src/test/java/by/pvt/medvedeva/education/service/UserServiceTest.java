package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.entity.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anastasiya Medvedeva
 */
public class UserServiceTest {
    UserServiceImpl service = UserServiceImpl.getInstance();

    /**
     * @throws Exception
     */
    @Test
    public void createUserTest() throws Exception {
        User user = new User(null, "Boris", "Bigun", "bobi", "nuinui", 0);
        // create() Method
        service.create(user);
        // getById() Method
        User userTest = service.getById(user.getIdUser());
        service.delete(user.getIdUser());
        Assert.assertEquals("Пользователь не совпадает", user, userTest);
    }

    /**
     * @throws Exception
     */
    @Test
    public void deleteUserTest() throws Exception {
        User user = new User(null, "Ivan", "Ruchkin", "naruch", "htfres", 0);
        service.create(user);
        // getByLogin() Method
        User userTest = service.getByLogin("naruch");
        // delete() Method
        service.delete(userTest.getIdUser());
        Assert.assertNull("Ошибка в методе удаления", service.getById(user.getIdUser()));
    }

}