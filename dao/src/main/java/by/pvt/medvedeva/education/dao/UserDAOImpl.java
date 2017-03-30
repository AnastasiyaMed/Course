package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class UserDAOImpl implements UserDAO {

	public static final String SQL_QUERY_ADD_USER = "INSERT INTO user (name, surname, login, password, role) VALUES (?,?,?,?,?)";
	public static final String SQL_QUERY_GET_USER = "SELECT *  FROM user WHERE user.login = ?";
	public static final String SQL_QUERY_CHECK_LOGIN = "SELECT login  FROM user WHERE user.login = ?";

	@Override
	public void addUser(User user)  {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionPool pool = new ConnectionPool();
			Properties properties = pool.getConnectProperties();
			conn = pool.getConnect(properties);
			preparedStatement = conn.prepareStatement(SQL_QUERY_ADD_USER);
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
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User getUserByLogin(final String login)  {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			ConnectionPool pool = new ConnectionPool();
			Properties properties = pool.getConnectProperties();
			conn = pool.getConnect(properties);
			preparedStatement = conn.prepareStatement(SQL_QUERY_GET_USER);
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
				if (conn != null) {
					conn.close();
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
	public boolean CheckLogin(String login) throws SQLException {
		ConnectionPool pool = new ConnectionPool();
		Properties properties = pool.getConnectProperties();
		Connection connection = pool.getConnect(properties);
		PreparedStatement ps = null;
		String query = SQL_QUERY_CHECK_LOGIN;
		ps = connection.prepareStatement(query);
		ps.setString(1, login);
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			connection.close();
			return false;
		} else
			connection.close();
		return true;
	}
}
