package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.TeacherDAOImpl;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TeacherServiceTest {
    TeacherService service = TeacherService.getInstance();
    UserService userService = UserService.getInstance();




    @Test
    public void TeacherServiceTest() throws Exception {
        User user = new User(null, "Konst", "Konev", "kokon", "minore", 0);
        userService.create(user);
        // init() Method
        Teacher teacher = service.initTeacher(user);
        // create() Method
        service.create(teacher);
        // getAll() Method
        List <Teacher> teachers = service.getAll();
        // getByID() Method
        Teacher teacherTest = service.getById(teacher.getIdUser());

        TeacherDAOImpl.getInstance().delete(teacher.getIdUser());
        Assert.assertEquals("Преподаватель не совпадает", teacher, teacherTest);

    }


}