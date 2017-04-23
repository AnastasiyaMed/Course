/**
 *
 */
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;

import java.sql.SQLException;

/**
 * @author Medvedeva Anastasiya
 */
public class TeacherDAOImpl extends AbstractDAO <Teacher> implements TeacherDAO <Teacher> {
    private final static String SQL_QUERY_GET_TEACHER = "SELECT * FROM teacher, user  WHERE teacher.user_user_id = user.user_id AND teacher.teacher_id = ? ;";
    private final static String SQL_QUERY_ADD_TEACHER = "INSERT INTO `teacher` (`user_user_id`) VALUES (?)";
    private final static String SQL_QUERY_CHANGE_USERROLE = "UPDATE `user` SET `role`='2' WHERE  user.user_id = ?";
    private final static int TEACHER_ROLE = 2;
    private static TeacherDAOImpl instance;

    TeacherDAOImpl(ConnectionPool connectionPool) {
        super(Teacher.class);
        this.connectionPool = connectionPool;
    }

    /**
     * Singleton-fabric
     */
    public static TeacherDAOImpl getInstance() {
        if (instance == null) {
            instance = new TeacherDAOImpl((MySQLConnectionPool.getInstance()));
        }
        return instance;
    }

    @Override
    public Teacher initTeacher(User user) {


        Teacher teacher = new Teacher();

        teacher.setName(user.getName());
        teacher.setSurname(user.getSurname());
        teacher.setLogin(user.getLogin());
        teacher.setPassword(user.getPassword());
        teacher.setRole(TEACHER_ROLE);
        teacher.setIdUser(user.getIdUser());

        return teacher;
    }

    @Override
    public void create(Teacher teacher) throws DAOException {
        preparedStatement = null;
        try {
            connection = connectionPool.getConnect();
            preparedStatement = connection.prepareStatement(SQL_QUERY_CHANGE_USERROLE);
            preparedStatement.setInt(1, teacher.getIdUser());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            connection = connectionPool.getConnect();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_TEACHER);
            preparedStatement.setInt(1, teacher.getIdUser());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Some trouble whith connect to database", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Some trouble whith connect to database", e);
            }
        }
    }


//    @Override
//    public Teacher initTeacherFromBD(int idTeacher) throws DAOException {
//        preparedStatement = null;
//        resultSet = null;
//        Teacher teacher = null;
//        try {
//            connection = connectionPool.getConnect();
//            preparedStatement = connection.prepareStatement(SQL_QUERY_GET_TEACHER);
//            preparedStatement.setInt(1, idTeacher);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                teacher = new Teacher();
//                teacher.setIdUser(resultSet.getInt("user_id"));
//                teacher.setLogin(resultSet.getString("login"));
//                teacher.setName(resultSet.getString("name"));
//                teacher.setSurname(resultSet.getString("surname"));
//                teacher.setPassword(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Some trouble whith connect to database", e);
//        } finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                throw new DAOException("Some trouble whith connect to database", e);
//            }
//        }
//        System.out.println(teacher);
//        return teacher;
//    }




}