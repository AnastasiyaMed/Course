//package by.pvt.medvedeva.education.service;
//
//import by.pvt.medvedeva.education.dao.StudentDAOImpl;
//import by.pvt.medvedeva.education.entity.Student;
//import by.pvt.medvedeva.education.entity.User;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//
///**
// * @author Anastasiya Medvedeva
// */
//public class StudentServiceTest {
//    StudentServiceImpl service = StudentServiceImpl.getInstance();
//    UserServiceImpl userService = UserServiceImpl.getInstance();
//
//    /**
//     * \
//     *
//     * @throws Exception
//     */
//    @Test
//    public void StudentServiseTest() throws Exception {
//        User user = new User(null, "Gena", "Gajiev", "gega", "gegege", 0);
//        userService.create(user);
//        // init() Method
//        Student student = service.initStudent(user, 5, 4.5, 45);
//        // create() Method
//        service.create(student);
//        List <Student> students = StudentDAOImpl.getInstance().getAll();
//        Student studentTest = new Student();
//        for (Student s : students) {
//            if (s.getFirstName().equals(student.getFirstName())) {
//                studentTest = s;
//            }
//        }
//        StudentDAOImpl.getInstance().delete(studentTest.getIdUser());
//        Assert.assertEquals("Студент не совпадает", student, studentTest);
//    }
//
//}