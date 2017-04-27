package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Pojo;

import java.util.List;

public interface BaseDAO<T extends Pojo> {

     void create (T entity) throws DAOException;


    T getById(Integer id) throws DAOException;


    void update (T pojo) throws DAOException;

    List<T> getAll() throws DAOException;



    void delete (Integer id) throws DAOException;
}
