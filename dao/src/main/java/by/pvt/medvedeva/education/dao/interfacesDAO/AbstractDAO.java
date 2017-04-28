package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public abstract class AbstractDAO<T extends Pojo> implements BaseDAO <T> {
    protected ConnectionPool connectionPool;
    protected HibernateUtil util = HibernateUtil.getHibernateUtil();
    protected Session session = util.getSession();
    protected Criteria criteria;
    private Class persistentClass;

    protected AbstractDAO(Class persistentClass) {
        this.persistentClass = persistentClass;
    }


    @Override
    public T getById(Integer id) throws DAOException {
        try {
            return (T) session.get(persistentClass, id);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in get method", e);
        }
    }

    @Override
    public void create(T pojo) throws DAOException {
        try {
            //       session = util.getSession();
            session.save(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in create method", e);
        }
    }

    @Override
    public void update(T pojo) throws DAOException {
        try {
            //             session = util.getSession();
            session.update(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in create method", e);
        }
    }

    @Override
    public List <T> getAll() throws DAOException {
        try {
            //          session = util.getSession();
            criteria = session.createCriteria(persistentClass);
            return criteria.list();
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in getAll method", e);
        }
    }

    @Override
    public void delete(Integer id) throws DAOException {
        try {
            //          session = util.getSession();
            T pojo = getById(id);
            session.delete(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in remove category method", e);
        }
    }

}
