package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.BaseDAO;
import by.pvt.medvedeva.education.entity.Pojo;
import by.pvt.medvedeva.education.service.interfaces.BaseService;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Medvedeva Anastasiya
 */
@Service
@Log4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public abstract class AbstractService<T extends Pojo> implements BaseService <T> {

    private BaseDAO <T> baseDAO;

    @Autowired
    protected AbstractService(BaseDAO <T> baseDAO) {
        this.baseDAO = baseDAO;
    }

    /**
     * @param entity
     * @throws DAOException
     */
    @Override
    public void create(T entity) throws DAOException {
        try {
            baseDAO.create(entity);
        } catch (HibernateException e) {
            log.error("Transaction failed in create  method" + e);
            throw new DAOException(AbstractService.class, "Transaction failed in create  method", e);
        }
    }


    /**
     * @param id
     * @return teacher
     * @throws DAOException
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T getById(Integer id) throws DAOException {
        T entity;
        try {
            entity = baseDAO.getById(id);

        } catch (HibernateException e) {
            log.error("Transaction failed in getById method" + e);
            throw new DAOException(getClass(), "Transaction failed in getById method", e);
        }
        return entity;
    }


    /**
     * @return
     * @throws DAOException
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List <T> getAll() throws DAOException {
        List <T> entityList;
        try {
            entityList = baseDAO.getAll();
        } catch (HibernateException e) {
            log.error("Transaction failed in getAll method" + e);
            throw new DAOException(getClass(), "Transaction failed in getAll method", e);
        }
        return entityList;
    }


    /**
     * @param id
     * @throws DAOException
     */
    @Override
    public void delete(Integer id) throws DAOException {
        try {
            baseDAO.delete(id);
        } catch (HibernateException e) {
            log.error("Transaction failed in delete method" + e);
            throw new DAOException(getClass(), "Transaction failed in delete  method", e);
        }
    }
}

