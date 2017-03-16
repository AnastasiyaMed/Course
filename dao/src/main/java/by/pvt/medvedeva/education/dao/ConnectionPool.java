package by.pvt.medvedeva.education.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/***
 * 
 * @author Medvedeva Anastasiya
 *
 */
public class ConnectionPool {

	public Connection getConnect() {
		Connection connection = null;
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jndi/education");
			connection = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
