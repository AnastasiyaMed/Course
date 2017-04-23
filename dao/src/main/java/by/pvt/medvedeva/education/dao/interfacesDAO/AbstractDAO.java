package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAO<T extends Pojo>  implements BaseDAO <T>{
    protected ConnectionPool connectionPool;
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;
    private static Logger log = Logger.getLogger(AbstractDAO.class);
    protected HibernateUtil util = HibernateUtil.getHibernateUtil();
    protected Session session;
    private Class persistentClass;

    protected AbstractDAO (Class persistentClass){
        this.persistentClass = persistentClass;
    }




    @Override
    public T getById(Integer id) throws DAOException {
        try {
            session = util.getSession();
            return (T) session.get(persistentClass, id);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in get method", e);
        }
    }

    @Override
    public void create(T pojo) throws DAOException {

        try {
            session = util.getSession();
            session.save(pojo);
        } catch (HibernateException e) {
            throw new DAOException(persistentClass, "Fatal error in create method", e);
        }

    }


}
