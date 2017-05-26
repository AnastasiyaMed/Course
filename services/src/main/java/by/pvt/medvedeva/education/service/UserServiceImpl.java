/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Anastasiya Medvedeva
 */
@Service
@Log4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class UserServiceImpl extends AbstractService <User> implements UserService {

    @Autowired
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }


      /**
     * @param login
     * @return user
     * @throws DAOException
     */
      @Override
      @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getByLogin(String login) throws DAOException {
        User user;
        try {
            user =  userDAO.getByLogin(login);
              } catch (HibernateException e) {
            log.error("Transaction failed in getByLogin method" + e);
             throw new DAOException(UserServiceImpl.class, "Transaction failed in getByLogin method", e);
        }
        return user;
    }


    /**
     * @param login
     * @return result
     * @throws DAOException
     */
    @Override
    public boolean checkLogin(String login) throws DAOException {
        boolean resultCheckLogin = true;
        if (null == getByLogin(login)) {
            resultCheckLogin = false;
        }
        return resultCheckLogin;
    }

   }
