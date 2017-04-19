package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.H2ConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAOImplTest {
    private final static  String SQL_QUERY_GET_TEACHERID = "SELECT * FROM teacher, `user`  WHERE teacher.user_user_id = `user`.user_id AND `user`.user_id = ?";
//    private final static  String SQL_QUERY_GET_TEACHERID = "SELECT * FROM teacher, `user`  WHERE teacher.user_user_id = `user`.user_id AND `user`.login = ?";
    private TeacherDAOImpl dao = new TeacherDAOImpl(H2ConnectionPool.getInstance());

    public TeacherDAOImplTest() throws SQLException {
    }


    public int setUpTeacherID() throws Exception {
User user = new User(1, "d", "s", "c", "c", 2);
    UserDAOImpl userDAO = new UserDAOImpl(H2ConnectionPool.getInstance());
        userDAO.create(user);
    User userTest = userDAO.getUserByLogin(user.getLogin());
    Teacher teacher = dao.initTeacher(userTest);
       dao.create(teacher);
    int userID = userTest.getIdUser();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
        try {
        connection =  H2ConnectionPool.getInstance().getConnect();
        preparedStatement = connection.prepareStatement(SQL_QUERY_GET_TEACHERID);
        preparedStatement.setInt(1, userID);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            teacher.setIdTeacher(resultSet.getInt("teacher_id"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } return teacher.getIdTeacher();
    }

    @Test
    public void initTeacherTest() throws Exception {
        User user = new User(0, "w", "w", "w", "w", 2);
        Teacher teacher = dao.initTeacher(user);
        dao.create(teacher);
        Teacher teacherTest = dao.initTeacher(user);
        Assert.assertEquals("Ошибка чтения данных преподавателя из базы", "w", teacherTest.getLogin());
    }

    @Test
    public void initTeacherFromBDTest() throws Exception {
        Teacher teacherTest = dao.initTeacherFromBD(setUpTeacherID());
        Assert.assertNotNull("преподаватель не найден в базе", teacherTest);
    }

    @Test
    public void createTest() throws Exception {
                Teacher teacherTest = dao.initTeacherFromBD(setUpTeacherID());
                Assert.assertEquals("Ошибка чтения создания преподавателя в базе", "c", teacherTest.getLogin());
    }

}