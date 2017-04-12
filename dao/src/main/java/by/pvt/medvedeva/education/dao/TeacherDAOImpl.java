/**
 *
 */
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Medvedeva Anastasiya
 */
public class TeacherDAOImpl extends AbstractDAO<Teacher> implements TeacherDAO<Teacher>  {
    public static final String SQL_QUERY_GET_TEACHER = "SELECT * FROM teacher, user, course  WHERE teacher.user_user_id = user.user_id AND course.teacher_teacher_id = teacher.teacher_id  AND user.user_id = ? ;";
    public static final String SQL_QUERY_ADD_TEACHER = "INSERT INTO `education`.`teacher` (`user_user_id`) VALUES (?)";
    public static final String SQL_QUERY_CHANGE_USERROLE = "UPDATE `education`.`user` SET `role`='2' WHERE  user.user_id = ?";
    private final static int TEACHER_ROLE = 2;
    private static TeacherDAOImpl instance;
    /**
     * Singleton-fabric
     *
     */
    public static TeacherDAOImpl getInstance() {
        if (instance == null) {
            instance = new TeacherDAOImpl();
        }
        return instance;
    }

    @Override
    public Teacher initTeacher(User user) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Teacher teacher = new Teacher();
        try {
           //Properties properties = MySQLConnectionPool.getInstance().getConnectProperties();
            connection = MySQLConnectionPool.getInstance().getConnect();
            int IdUser = user.getIdUser();
            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_TEACHER);
            preparedStatement.setInt(1, IdUser);
            resultSet = preparedStatement.executeQuery();
            teacher.setName(user.getName());
            teacher.setSurname(user.getSurname());
            teacher.setLogin(user.getLogin());
            teacher.setPassword(user.getPassword());
            teacher.setRole(TEACHER_ROLE);
            teacher.setIdUser(user.getIdUser());
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
        }
        return teacher;
    }

    @Override
    public void create(Teacher teacher) {
         PreparedStatement preparedStatement = null;
        try {
         //   Properties properties = MySQLConnectionPool.getInstance().getConnectProperties();
            connection = MySQLConnectionPool.getInstance().getConnect();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_TEACHER);
            preparedStatement.setInt(1, teacher.getIdUser());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            preparedStatement = connection.prepareStatement(SQL_QUERY_CHANGE_USERROLE);
            preparedStatement.setInt(1, teacher.getIdUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}
