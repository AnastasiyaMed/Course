//package by.pvt.medvedeva.education.service;
//
//import by.pvt.medvedeva.education.entity.Course;
//import by.pvt.medvedeva.education.entity.User;
//import by.pvt.medvedeva.education.service.interfaces.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//
///**
// * @author Anastasiya Medvedeva
// */
//@ContextConfiguration("/service-context-test.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserServiceImplTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void getUserByLoginTest() throws Exception {
//        User expected = new User(null, "Test", "User", "login", "password", null, new ArrayList<Course>());
//        userService.create(expected);
//        User actual = userService.getByLogin(expected.getLogin());
//        Assert.assertEquals("Not valid", expected, actual);
//    }
//
//}
