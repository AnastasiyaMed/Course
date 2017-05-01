package by.pvt.medvedeva.education.logic;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anastasiya Medvedeva
 */
public class LoginLogicTest {
    UserService service = UserService.getInstance();

    /**
     * @throws Exception
     */
    @Test
    public void checkUserRole() throws Exception {
        User user = new User(null, "Nastena", "Medvedeva", "Medana", "frrehfnyj", 3);
        service.create(user);
        Integer role = LoginLogic.checkUserRole("Medana");
        service.delete(user.getIdUser());
        Assert.assertEquals("Роль не совпадает", (Integer) 3, role);
    }

    /**
     * @throws Exception
     */
    @Test
    public void getUserPasswordForCheck() throws Exception {
        User user = new User(null, "John", "Doh", "jonny", "donido", 0);
        service.create(user);
        String password = LoginLogic.GetUserPasswordForCheck("jonny");
        service.delete(user.getIdUser());
        Assert.assertEquals("пароль не совпадает", user.getPassword(), password);
    }

}