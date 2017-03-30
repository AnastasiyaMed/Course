package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.User;

import java.sql.SQLException;

public interface UserDAO {

	User getUserByLogin(final String login);

	void addUser(final User user);


	boolean CheckLogin(String login) throws SQLException;

}
