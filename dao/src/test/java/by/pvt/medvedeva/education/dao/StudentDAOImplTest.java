package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import org.junit.*;
import static junit.framework.Assert.*;

public class StudentDAOImplTest {
    public StudentDAOImplTest() {
    }

    @Test
    public void initStudent() throws Exception {
        UserDAOImpl userDAO = new UserDAOImpl(H2ConnectionPool.getInstance());
        User user = new User();
        user.setLogin("vac");
        user.setName("Vasia");
        user.setSurname("Curicin");
        user.setPassword("111111");
        user.setRole(1);
        StudentDAOImpl dao = new StudentDAOImpl(H2ConnectionPool.getInstance());
        Student student = dao.initStudent(user, 2, 1.2, 123);
        assertEquals("Ошибка инициализации студента", "vac", student.getLogin());
    }

    @Test
    public void create() throws Exception {
        UserDAOImpl userDAO = new UserDAOImpl(H2ConnectionPool.getInstance());
        User user = new User();
        user.setLogin("vac");
        user.setName("Vasia");
        user.setSurname("Curicin");
        user.setPassword("111111");
        user.setRole(1);
        StudentDAOImpl dao = new StudentDAOImpl(H2ConnectionPool.getInstance());
        Student student = dao.initStudent(user, 3, 3.4, 342);
        dao.create(student);
        Student studentTest = dao.initStudentFromBD(user);
        assertEquals("Ошибка добавления студента", "vac", studentTest.getLogin());

    }

}