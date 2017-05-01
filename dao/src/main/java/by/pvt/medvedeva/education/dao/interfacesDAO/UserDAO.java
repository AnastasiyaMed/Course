package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;

/**
 * @author Medvedeva Anastasiya
 */
public interface UserDAO<User> {

    /**
     * @param login
     * @return
     * @throws DAOException
     */
    public User getByLogin(String login) throws DAOException;

}
