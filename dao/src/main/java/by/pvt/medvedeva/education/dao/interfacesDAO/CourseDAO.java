package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;

import java.util.List;


public interface CourseDAO extends BaseDAO<Course> {



    List<Course> getCourseByPage(int pageOffset, int pageCapacity ) throws DAOException;


    int getCoursesCount() throws DAOException;


}
