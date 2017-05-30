package by.pvt.medvedeva.education.service.interfaces;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;

import java.util.List;

public interface CourseService extends BaseService<Course> {


    List<Course> getCoursesByPage(int pageNumber, int pageCapacity ) throws DAOException;


    int getCoursesCount() throws DAOException;


}
