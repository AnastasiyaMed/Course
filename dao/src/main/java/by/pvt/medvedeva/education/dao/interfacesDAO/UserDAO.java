package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exeption.DAOException;

public interface UserDAO  <User>{

	User getUserByLogin(final String login) throws DAOException;

	boolean CheckLogin(String login) throws DAOException;

}
