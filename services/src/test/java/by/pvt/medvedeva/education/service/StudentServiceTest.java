package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.StudentDAOImpl;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    StudentService service = StudentService.getInstance();
    UserService userService = UserService.getInstance();


    @Test
    public void StudentServiseTest() throws Exception {
        User user = new User(null, "Gena", "Gajiev", "gega", "gegege", 0);
        userService.create(user);
        // init() Method
        Student student = service.initStudent(user, 5, 4.5, 45);
        // create() Method
        service.create(student);
        List <Student> students = StudentDAOImpl.getInstance().getAll();
        Student studentTest = new Student();
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                studentTest = s;
            }
        }
        StudentDAOImpl.getInstance().delete(studentTest.getIdUser());
        Assert.assertEquals("Студент не совпадает", student, studentTest);
    }

}