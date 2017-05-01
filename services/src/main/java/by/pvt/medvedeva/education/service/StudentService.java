/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.StudentDAOImpl;
import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;


/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class StudentService extends AbstractService {
    private StudentDAOImpl studentDAO;
    private static StudentService instance;

    /**
     * Singleton-fabric
     */
    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    /**
     * no param
     */
    public StudentService() {
        studentDAO = StudentDAOImpl.getInstance();
    }

    /**
     * @param user
     * @param level
     * @param average
     * @param cardId
     * @return
     */
    public Student initStudent(User user, int level, double average, int cardId) {
        return (Student) studentDAO.initStudent(user, level, average, cardId);
    }

    /**
     * @param student
     * @throws DAOException
     */
    public void create(Student student) throws DAOException {
        Integer id = student.getIdUser();
        try {
            session = util.getSession();
            //     getTransaction();
            studentDAO.create(student);
            UserService.getInstance().delete(id);
            //       commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in create student method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create student method", e);
        }
    }

}
