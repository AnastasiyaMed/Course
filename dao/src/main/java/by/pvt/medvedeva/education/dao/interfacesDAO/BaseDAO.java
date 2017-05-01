package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;

import java.util.List;

/**
 * Base interface for DAO layer
 *
 * @param <T>
 */
public interface BaseDAO<T extends Pojo> {
    /**
     * @param entity
     * @throws DAOException
     */
    void create(T entity) throws DAOException;

    /**
     * @param id
     * @return
     * @throws DAOException
     */
    T getById(Integer id) throws DAOException;

    /**
     * @param pojo
     * @throws DAOException
     */
    void update(T pojo) throws DAOException;

    /**
     * @return
     * @throws DAOException
     */
    List <T> getAll() throws DAOException;


    /**
     * @param id
     * @throws DAOException
     */
    void delete(Integer id) throws DAOException;
}
