package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class UserDAOImpl extends AbstractDAO <User> implements UserDAO <User> {
    private static UserDAOImpl instance;
    private  HibernateUtil util = HibernateUtil.getHibernateUtil();
    protected  Session session = util.getSession();
    ;

    UserDAOImpl(ConnectionPool connectionPool) {
        super(User.class);
        this.connectionPool = connectionPool;
    }

    /**
     * Singleton-fabric
     */
    public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl(MySQLConnectionPool.getInstance());
        }
        return instance;
    }


    @Override
    public User getByLogin(String login) throws DAOException {
        try {

            return (User) session.createCriteria(User.class)
                    .add(Restrictions.like("login", login))
                    .uniqueResult();
        } catch (HibernateException e) {
            throw new DAOException(User.class, "Fatal error in get method", e);
        }
    }
}

