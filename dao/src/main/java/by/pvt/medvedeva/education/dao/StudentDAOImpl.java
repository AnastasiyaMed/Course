
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author Medvedeva Anastasiya
 */
@Repository
public class StudentDAOImpl extends AbstractDAO <Student> implements StudentDAO {

    @Autowired
    private StudentDAOImpl(SessionFactory sessionFactory) {
        super(Student.class, sessionFactory);
    }

}
