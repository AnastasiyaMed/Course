package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl extends AbstractDAO<User> implements UserDAO<User>  {

	private static final String SQL_QUERY_ADD_USER = "INSERT INTO user (name, surname, login, password, role) VALUES (?,?,?,?,?)";
	private static final String SQL_QUERY_GET_USER = "SELECT *  FROM user WHERE user.login = ?";
	private static final String SQL_QUERY_CHECK_LOGIN = "SELECT login  FROM user WHERE user.login = ?";
	private static UserDAOImpl instance;

	 UserDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	/**
	 * Singleton-fabric
	 *
	 */
	public static UserDAOImpl getInstance() {
		if (instance == null) {
			instance = new UserDAOImpl(MySQLConnectionPool.getInstance());
		}
		return instance;
	}

	@Override
	public void create(User user) {
	    preparedStatement = null;
		try {
			connection = connectionPool.getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getLogin());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getRole());
			preparedStatement.executeUpdate();

		}
			catch (SQLException e) {
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

	@Override
	public User getUserByLogin(final String login)  {
		preparedStatement = null;
		resultSet = null;
		User user = new User();
		try {
			connection = connectionPool.getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_USER);
			preparedStatement.setString(1, login);
			resultSet = preparedStatement.executeQuery();
			user = initUser(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
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
		return user;
	}

	private User initUser(ResultSet resultSet)  {
		User user = new User();
		try {
		while (resultSet.next()) {
			user.setIdUser(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setSurname(resultSet.getString(3));
			user.setLogin(resultSet.getString(4));
			user.setPassword(resultSet.getString(5));
			user.setRole(resultSet.getInt(6));
			} }
			catch (SQLException e) {
				e.printStackTrace();
			}
				return user;
	}



	@Override
	public boolean CheckLogin(String login)  {
		boolean checkedLogin = true;
		preparedStatement = null;
		try {
			connection = connectionPool.getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_CHECK_LOGIN);

			preparedStatement.setString(1, login);
		    resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
			connection.close();
			checkedLogin = true;
		} else {
			checkedLogin = false;
			connection.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkedLogin;
	}
}
