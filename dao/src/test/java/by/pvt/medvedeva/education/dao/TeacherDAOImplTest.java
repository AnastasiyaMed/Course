//package by.pvt.medvedeva.education.dao;
//
//import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
//import by.pvt.medvedeva.education.entity.Teacher;
//import by.pvt.medvedeva.education.entity.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @author Medvedeva Anastasiya
// */
//@ContextConfiguration("/context-dao-test.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional(transactionManager = "transactionManager")
//public class TeacherDAOImplTest {
//    @Autowired
//    private TeacherDAO teacherDAO;
//
//
//    /**
//     * @throws Exception
//     */
//    @Test
//    public void initTeacherTest() throws Exception {
//        User user = new User(0, "w", "w", "return", "w", 2);
//        Teacher teacher = teacherDAO.initTeacher(user);
//        Assert.assertEquals("Ошибка инициализации преподавателя", "return", teacher.getLogin());
//    }
//
//    /**
//     * @throws Exception
//     */
//    @Test
//    public void getByIdTest() throws Exception {
//        Teacher teacher = new Teacher(null, "w", "w", "w", "w", 2);
//        teacherDAO.create(teacher);
//        Teacher teacherTest = teacherDAO.getById(teacher.getIdUser());
//        Assert.assertEquals("преподаватель не найден в базе", teacher, teacherTest);
//    }
//
//    /**
//     * @throws Exception
//     */
//    @Test
//    public void createTest() throws Exception {
//        User user = new User();
//        user.setLogin("tim");
//        user.setFirstName("John");
//        user.setSurname("Sinicin");
//        user.setPassword("111111");
//        user.setRole(2);
//        Teacher teacher = teacherDAO.initTeacher(user);
//        teacherDAO.create(teacher);
//        Teacher teacherTest = teacherDAO.getById(teacher.getIdUser());
//        Assert.assertEquals("Ошибка добавления преподавателя", teacher, teacherTest);
//    }
//}