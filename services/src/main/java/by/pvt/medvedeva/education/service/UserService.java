/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.UserDAOImpl;
import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;


/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class UserService extends AbstractService {
    private static UserService instance;
    private UserDAO userDAO = UserDAOImpl.getInstance();

    /**
     * no param
     */
    public UserService() {
        userDAO = UserDAOImpl.getInstance();
    }

    /**
     * Singleton-fabric
     */
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    /**
     * @param id
     * @return user
     * @throws DAOException
     */
    protected User getById(Integer id) throws DAOException {
        User user = UserDAOImpl.getInstance().getById(id);
        return user;
    }

    /**
     * @param login
     * @return user
     * @throws DAOException
     */
    public User getByLogin(String login) throws DAOException {
        User user;
        try {
            session = util.getSession();
            //     getTransaction();
            user = UserDAOImpl.getInstance().getByLogin(login);
            //     commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in getById method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in getById method", e);
        }
        return user;
    }

    /**
     * @param user
     * @throws DAOException
     */
    public void create(User user) throws DAOException {
        try {
            session = util.getSession();
            //      getTransaction();
            UserDAOImpl.getInstance().create(user);
            //      commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in create user method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create user method", e);
        }
    }

    /**
     * @param login
     * @return result
     * @throws DAOException
     */
    public boolean checkLogin(String login) throws DAOException {
        boolean resultCheckLogin = true;
        if (null == getByLogin(login)) {
            resultCheckLogin = false;
        }
        return resultCheckLogin;
    }

    /**
     * @param id
     * @throws DAOException
     */
    public void delete(Integer id) throws DAOException {
        try {
            session = util.getSession();
            //      getTransaction();
            UserDAOImpl.getInstance().delete(id);
            //      commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in delete user method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in delete user method", e);
        }
    }
}
