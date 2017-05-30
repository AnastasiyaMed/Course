package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.User;

/**
 * @author Medvedeva Anastasiya
 */
public interface UserDAO extends BaseDAO<User> {

    /**
     * @param login
     * @return
     * @throws DAOException
     */
    public User getByLogin(String login) throws DAOException;

}
