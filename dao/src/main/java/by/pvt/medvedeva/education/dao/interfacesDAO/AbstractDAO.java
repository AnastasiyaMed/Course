package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Medvedeva Anastasiya
 *         <p>
 *         Abstract class, base class for DAO layer
 */
public abstract class AbstractDAO<T extends Pojo> implements BaseDAO <T> {
    protected ConnectionPool connectionPool;
    protected HibernateUtil util = HibernateUtil.getHibernateUtil();
    protected Session session;
    protected Criteria criteria;
    private Class persistentClass;

    /**
     * Constructor
     *
     * @param persistentClass
     */
    protected AbstractDAO(Class persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public T getById(Integer id) throws DAOException {
        session = util.getSession();
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
        session = util.getSession();
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
        session = util.getSession();
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
        session = util.getSession();
        try {
            criteria = session.createCriteria(persistentClass);
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
    public void delete(Integer id) throws DAOException {
        try {
            session = util.getSession();
            T pojo = getById(id);
            session.delete(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in remove category method", e);
        }
    }

}
