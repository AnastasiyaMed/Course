package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exeption.DAOException;

public interface UserDAO  <User>{


	public  User  getByLogin (String login) throws DAOException;

}
