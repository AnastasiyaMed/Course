
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
    private final static int STUDENT_ROLE = 1;


    @Autowired
    private StudentDAOImpl(SessionFactory sessionFactory) {
        super(Student.class, sessionFactory);
    }


    /**
     * @param user
     * @param level
     * @param average
     * @param cardId
     * @return
     */
    @Override
    public Student initStudent(User user, int level, double average, int cardId) {
        Student student = new Student();
        student.setName(user.getName());
        student.setSurname(user.getSurname());
        student.setLogin(user.getLogin());
        student.setPassword(user.getPassword());
        student.setRole(STUDENT_ROLE);
        student.setIdUser(user.getIdUser());
        student.setLevel(level);
        student.setAverage(average);
        student.setStudentIdCard(cardId);
        return student;
    }

}
