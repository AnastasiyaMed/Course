/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.StudentService;
import by.pvt.medvedeva.education.service.interfaces.UserService;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Anastasiya Medvedeva
 */
@Service
@Log4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class StudentServiceImpl extends AbstractService <Student> implements StudentService {

    private final StudentDAO studentDAO;
    private final UserService userService;
    @Autowired
    protected StudentServiceImpl(StudentDAO studentDAO, UserService userService) {
        super(studentDAO);
        this.studentDAO = studentDAO;
        this.userService = userService;
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
        return (Student) studentDAO.initStudent(user, level, average, cardId);
    }

    /**
     * @param student
     * @throws DAOException
     */
    @Override
    public void create(Student student) throws DAOException {
        Integer id = student.getIdUser();
        try {
            studentDAO.create(student);
            userService.delete(id);
        } catch (HibernateException e) {
            log.error("Transaction failed in create student method" + e);
            throw new DAOException(StudentServiceImpl.class, "Transaction failed in create student method", e);
        }
    }

}
