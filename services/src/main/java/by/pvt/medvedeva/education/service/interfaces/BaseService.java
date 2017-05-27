package by.pvt.medvedeva.education.service.interfaces;


import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;

import java.util.List;

public interface BaseService <T extends Pojo>  {

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
    T getById(Long id) throws DAOException;

    /**
     * @param pojo
     * @throws DAOException
     */
    void update(T pojo) throws DAOException;

    /**
     * @return
     * @throws DAOException
     */
    List<T> getAll() throws DAOException;


    /**
     * @param id
     * @throws DAOException
     */
    void delete(Long id) throws DAOException;


}
