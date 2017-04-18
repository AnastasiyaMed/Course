package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TeacherDAOImplTest {
    private TeacherDAOImpl dao = new TeacherDAOImpl(H2ConnectionPool.getInstance());

    public TeacherDAOImplTest() throws SQLException {
    }


    @Test
    public void initTeacherTest() throws Exception {
        User user = new User(2, "w", "w", "w", "w", 2);
        Teacher teacher = dao.initTeacher(user);
        dao.create(teacher);
        Teacher teacherTest = dao.initTeacher(user);
        Assert.assertEquals("Ошибка чтения данных преподавателя из базы", "w", teacherTest.getLogin());
    }

    @Test
    public void createTest() throws Exception {
        User user = new User(2,"w","e","d", "w", 0);
        Teacher teacher = new Teacher(2, 2, "w", "e", "d", "w", 2);
        dao.create(teacher);
        Teacher teacherTest = dao.initTeacher(user);
        Assert.assertEquals("Ошибка чтения создания преподавателя в базе", "d", teacherTest.getLogin());
    }

}