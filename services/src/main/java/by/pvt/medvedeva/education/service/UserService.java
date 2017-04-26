/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.UserDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;

import java.io.IOException;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class UserService {
	private UserDAO userDAO;
	private static UserService instance;

	/**
	 * Singleton-fabric
	 *
	 */
	public static  UserService getInstance() {
		if (instance == null) {
			instance = new  UserService();
		}
		return instance;
	}

	public UserService() {
		userDAO = UserDAOImpl.getInstance();
	}

	public User getUser(String enterLogin) throws IOException, DAOException {
		return (User) userDAO.getUserByLogin(enterLogin);
	}



	public void addUser(User user) throws DAOException {
    UserDAOImpl.getInstance().AddUser(user);
	}



	public boolean checkLogin(String login) throws DAOException {
		boolean resultCheckLogin = true;
		resultCheckLogin = userDAO.CheckLogin(login);
		return resultCheckLogin;
	}

}
