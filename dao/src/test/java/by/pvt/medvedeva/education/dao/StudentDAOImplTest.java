//package by.pvt.medvedeva.education.dao;
//
//import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
//import by.pvt.medvedeva.education.entity.Student;
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
//public class StudentDAOImplTest {
//    @Autowired
//    private StudentDAO studentDAO;
//
//
//    @Test
//    public void initStudentTest() throws Exception {
//        User user = new User();
//        user.setLogin("vac");
//        user.setFirstName("Vasia");
//        user.setSurname("Curicin");
//        user.setPassword("111111");
//        user.setRole(1);
//        Student student = studentDAO.initStudent(user, 2, 1.2, 123);
//        Assert.assertEquals("Ошибка инициализации студента", "vac", student.getLogin());
//    }
//
//    /**
//     * @throws Exception
//     */
//    @Test
//    public void createTest() throws Exception {
//        User user = new User();
//        user.setLogin("vac");
//        user.setFirstName("Vasia");
//        user.setSurname("Curicin");
//        user.setPassword("111111");
//        user.setRole(1);
//        Student student = studentDAO.initStudent(user, 3, 3.4, 342);
//        studentDAO.create(student);
//        Student studentTest = studentDAO.getById(student.getIdUser());
//        Assert.assertEquals("Ошибка добавления студента", student, studentTest);
//    }
//
//}