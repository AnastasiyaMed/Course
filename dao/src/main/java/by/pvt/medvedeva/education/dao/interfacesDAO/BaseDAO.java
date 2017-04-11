package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.entity.Entity;

public interface BaseDAO<T extends Entity> {

     void create (T entity);


  //  void addNewEntity(Course course);
}
