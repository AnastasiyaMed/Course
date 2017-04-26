package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import org.junit.*;

import java.sql.SQLException;


public class StudentDAOImplTest {

   private StudentDAOImpl dao = new StudentDAOImpl(H2ConnectionPool.getInstance());

    public StudentDAOImplTest() throws SQLException {

    }





    @Test
    public void initStudentTest() throws Exception {
        StudentDAOImpl dao = new StudentDAOImpl(H2ConnectionPool.getInstance());
        User user = new User();
        user.setLogin("vac");
        user.setName("Vasia");
        user.setSurname("Curicin");
        user.setPassword("111111");
        user.setRole(1);
        Student student = dao.initStudent(user, 2, 1.2, 123);
        Assert.assertEquals("Ошибка инициализации студента", "vac", student.getLogin());
    }

//    @Test
//    public void createTest() throws Exception {
//        StudentDAOImpl dao = new StudentDAOImpl(H2ConnectionPool.getInstance());
//        User user = new User();
//        user.setLogin("vac");
//        user.setName("Vasia");
//        user.setSurname("Curicin");
//        user.setPassword("111111");
//        user.setRole(0);
//        Student student = dao.initStudent(user, 3, 3.4, 342);
//        dao.create(student);
//        Student studentTest = dao.initStudentFromBD(user);
//        Assert.assertEquals("Ошибка добавления студента", "vac", studentTest.getLogin());
//    }

}