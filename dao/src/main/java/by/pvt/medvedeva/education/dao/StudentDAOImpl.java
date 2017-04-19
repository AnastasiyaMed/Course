
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;

import java.sql.SQLException;


/**
 * @author Medvedeva Anastasiya
 *
 */
public class StudentDAOImpl extends AbstractDAO<Student> implements StudentDAO<Student> {
	private static final String SQL_QUERY_GET_STUDENT_BY_USER = "SELECT * FROM student, user  WHERE student.user_user_id = user.user_id AND user.user_id = ?";
	private static final String SQL_QUERY_ADD_STUDENT = "INSERT INTO `student` (`level`, `average`, `student_id_card`, `user_user_id`) VALUES (?,?,?,?)";
	private static final String SQL_QUERY_CHANGE_USERROLE = "UPDATE `user` SET `role`='1' WHERE  user.user_id = ?";
	private final static int STUDENT_ROLE = 1;
	private static StudentDAOImpl instance;

	StudentDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	/**
	 * Singleton-fabric
	 *
	 */
	public static StudentDAOImpl getInstance() {
		if (instance == null) {
			instance = new StudentDAOImpl(MySQLConnectionPool.getInstance());
		}
		return instance;
	}

	@Override
	public Student initStudent(User user, int level, double average, int cardId) {
		Student student = new Student();
			student.setName(user.getName());
			student.setSurname(user.getSurname());
			student.setLogin(user.getLogin());
			student.setPassword(user.getPassword());
			student.setRole(STUDENT_ROLE);
			student.setIdUser(user.getIdUser());
			student.setLevel(level);
			student.setAverage(average);
			student.setStudentIdCard(cardId);

		return student;
	}

	@Override
	public Student initStudentFromBD(User user) throws DAOException {
		preparedStatement = null;
		resultSet = null;
		Student student = new Student();
		try {

			connection = connectionPool.getConnect();
			int idUser = user.getIdUser();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_STUDENT_BY_USER);
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
				student.setStudentIdCard(resultSet.getInt("student_id_card"));
			}
		} catch (SQLException e) {

			throw new DAOException("Some trouble whith connect to database", e);
		}  finally {
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
				throw new DAOException("Some trouble whith connect to database", e);
			}
		}
		return student;
	}

	@Override
		public void create (Student student) throws DAOException {
		preparedStatement = null;
		try {
			connection = connectionPool.getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_CHANGE_USERROLE);
			preparedStatement.setInt(1, student.getIdUser());
			preparedStatement.executeUpdate();
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_STUDENT);
			preparedStatement.setInt(1, student.getLevel());
			preparedStatement.setDouble(2, student.getAverage());
			preparedStatement.setInt(3, student.getStudentIdCard());
			preparedStatement.setInt(4, student.getIdUser());
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
	}
