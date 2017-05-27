package by.pvt.medvedeva.education.dao;


import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.BaseDAO;
import by.pvt.medvedeva.education.entity.Pojo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Medvedeva Anastasiya
 *         <p>
 *         Abstract class, base class for DAO layer
 */

@Repository
public abstract class AbstractDAO<T extends Pojo> implements BaseDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;
    private Class persistentClass;

    Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected AbstractDAO(Class persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
    }

    /**
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public T getById(Long id) throws DAOException {
        Session session = currentSession();
        try {
            return (T) session.get(persistentClass, id);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in get method", e);
        }
    }

    /**
     * @param pojo
     * @throws DAOException
     */
    @Override
    public void create(T pojo) throws DAOException {
        Session session = currentSession();
        try {
            session.save(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in create method", e);
        }
    }

    /**
     * @param pojo
     * @throws DAOException
     */
    @Override
    public void update(T pojo) throws DAOException {
        Session session = currentSession();
        try {
            session.update(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in create method", e);
        }
    }

    /**
     * @return
     * @throws DAOException
     */
    @Override
    public List <T> getAll() throws DAOException {
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(persistentClass);
            return criteria.list();
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in getAll method", e);
        }
    }

    /**
     * @param id
     * @throws DAOException
     */
    @Override
    public void delete(Long id) throws DAOException {
        try {
            Session session = currentSession();
            T pojo = getById(id);
            session.delete(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in remove category method", e);
        }
    }

}
