package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Anastasiya Medvedeva
 */
@Repository
public class CourseDAOImpl extends AbstractDAO <Course> implements CourseDAO {


    @Autowired
    private CourseDAOImpl(SessionFactory sessionFactory) {
        super(Course.class, sessionFactory);
    }


}
