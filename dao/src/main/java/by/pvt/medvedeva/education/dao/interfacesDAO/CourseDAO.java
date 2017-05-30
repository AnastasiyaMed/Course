package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;

import java.util.List;

/**
 * Interface for operation whith Entity Course
 *
 */
public interface CourseDAO extends BaseDAO<Course> {


    /**
     * Method for realisation pagination.
     * @param pageOffset - means start value, from user will see list courses
     * @param pageCapacity - count courses on one page
     *
     */
    List<Course> getCourseByPage(int pageOffset, int pageCapacity ) throws DAOException;

    /**
     * Method for count all courses in DB.
     */
    int getCoursesCount() throws DAOException;


}
