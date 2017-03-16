
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Medvedeva Anastasiya
 *
 */
public class StudentDAOImpl implements StudentDAO {
	public static final String SQL_QUERY_GET_STUDENT = "SELECT * FROM student, user  WHERE student.user_user_id = user.user_id AND user.user_id = ?;";
	public static final String SQL_QUERY_ADD_STUDENT = "INSERT INTO `education`.`student` (`level`, `average`, `student_id_card`, `user_user_id`) VALUES (?,?,?,?)";
	public static final String SQL_QUERY_CHANGE_USERROLE = "UPDATE `education`.`user` SET `role`='1' WHERE  user.user_id = ?";
	private final static int STUDENT_ROLE = 1;

	@Override
	public Student initStudent(User user) {
			Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = new Student();
		try {
			ConnectionPool pool = new ConnectionPool();
			connection = pool.getConnect();
			int idUser = user.getIdUser();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_STUDENT);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			student.setName(user.getName());
			student.setSurname(user.getSurname());
			student.setLogin(user.getLogin());
			student.setPassword(user.getPassword());
			student.setRole(STUDENT_ROLE);
			student.setIdUser(user.getIdUser());
			while (resultSet.next()) {
				student.setIdStudent(resultSet.getInt("student_id"));
				student.setLevel(resultSet.getInt("level"));
				student.setAverage(resultSet.getDouble("average"));
				student.setAverage(resultSet.getInt("average"));
				student.setStudentIdCard(resultSet.getString("student_id_card"));
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
		return student;
	}



	@Override
	public void addStudent(Student student) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
						ConnectionPool pool = new ConnectionPool();
			conn = pool.getConnect();
			preparedStatement = conn.prepareStatement(SQL_QUERY_ADD_STUDENT);
			preparedStatement.setInt(1, student.getLevel());
			preparedStatement.setDouble(2, student.getAverage());
			preparedStatement.setString(3, student.getStudentIdCard());
			preparedStatement.setInt(4, student.getIdUser());
					preparedStatement.executeUpdate();
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			preparedStatement = conn.prepareStatement(SQL_QUERY_CHANGE_USERROLE);
			preparedStatement.setInt(1, student.getIdUser());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	}



