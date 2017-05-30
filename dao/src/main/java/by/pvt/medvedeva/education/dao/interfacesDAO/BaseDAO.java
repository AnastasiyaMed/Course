package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;

import java.util.List;

/**
 * Base interface for DAO layer
 *
 * @param <T>
 */
public interface BaseDAO <T extends Pojo> {

    /** Method for creating new
     * @param entity
     * @throws DAOException, whit describe what is problem happened if something wrong
     */
    void create(T entity) throws DAOException;


    /**
     * Method find and
     *  @return entity, by
     * @param id

     * @throws DAOException, whit describe what is problem happened if something wrong
     */
    T getById(Long id) throws DAOException;


    /** This method for update entity in DataBase
     * @param pojo
     * @throws DAOException
     */
    void update(T pojo) throws DAOException;

    /**
     * Method find and get all entity in DB
     * @return List <T>  (Collection of entity)
     * @throws DAOException
     */
    List <T> getAll() throws DAOException;


    /**
     * Method for deleting entity
     * @param id
     * @throws DAOException
     */
    void delete(Long id) throws DAOException;
}
