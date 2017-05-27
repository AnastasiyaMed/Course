/**
 *
 */
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Medvedeva Anastasiya
 */
@Repository
public class TeacherDAOImpl extends AbstractDAO <Teacher> implements TeacherDAO  {

    @Autowired
    private TeacherDAOImpl(SessionFactory sessionFactory) {
        super(Teacher.class, sessionFactory);
    }

}