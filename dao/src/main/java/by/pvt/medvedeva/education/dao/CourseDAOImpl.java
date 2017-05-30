package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
@Repository
public class CourseDAOImpl extends AbstractDAO <Course> implements CourseDAO {


    @Autowired
    private CourseDAOImpl(SessionFactory sessionFactory) {
        super(Course.class, sessionFactory);
    }


    @Override
    public List<Course> getCourseByPage(int pageOffset, int pageCapacity) throws DAOException {
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Course.class);

            // Pagination
            criteria.setMaxResults(pageCapacity);
            criteria.setFirstResult(pageOffset);
            // Sort order
            criteria.addOrder(Order.desc("name"));
            List<Course> courses = (List<Course>) criteria.list();
            return courses;
        } catch (HibernateException e) {
            throw new DAOException(Course.class, "Fatal error in pagination method", e);
        }
    }

    @Override
    public int getCoursesCount() throws DAOException {
        try{
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Course.class);
            return Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        } catch (HibernateException e) {
            throw new DAOException(Course.class, "Fatal error in count method", e);
        }

   }
}