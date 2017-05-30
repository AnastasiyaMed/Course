package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Medvedeva Anastasiya
 */
@Repository
public class UserDAOImpl extends AbstractDAO <User> implements UserDAO {

    @Autowired
    private UserDAOImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }


    /**
     * @param login
     * @return
     * @throws DAOException
     */
    @Override
    public User getByLogin(String login) throws DAOException {
        try {
            Session session = currentSession();
            return (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("login", login))
                    .uniqueResult();
        } catch (HibernateException e) {
            throw new DAOException(User.class, "Fatal error in getByLogin method", e);
        }
    }
}
