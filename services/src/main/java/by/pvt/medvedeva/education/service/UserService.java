/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.UserDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class UserService {
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private static UserService instance;
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session = util.getSession();

    private static Transaction transaction;

    /**
     * Singleton-fabric
     */
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public UserService() {
        userDAO = UserDAOImpl.getInstance();
    }


    protected User getById(Integer id) throws DAOException {
        User user = UserDAOImpl.getInstance().getById(id);
        return user;
    }

    public User getByLogin(String login) throws DAOException {
        User user;
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            user = UserDAOImpl.getInstance().getByLogin(login);
            transaction.commit();

        } catch (HibernateException e) {
            log.error("Transaction failed in getById method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in getById method", e);
        }

        return user;
    }

    public void create(User user) throws DAOException {

        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            UserDAOImpl.getInstance().create(user);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Transaction failed in create user method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create user method", e);
        }
    }

    public boolean checkLogin(String login) throws DAOException {
        boolean resultCheckLogin = true;
        if (null == getByLogin(login)) {
            resultCheckLogin = false;
        }
        return resultCheckLogin;
    }

    public void delete(Integer id) throws DAOException {

        try {
            session = util.getSession();
            if (transaction == null) {
                transaction = session.beginTransaction();
            }
            UserDAOImpl.getInstance().delete(id);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Transaction failed in create user method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in delete user method", e);
        }
    }
}
