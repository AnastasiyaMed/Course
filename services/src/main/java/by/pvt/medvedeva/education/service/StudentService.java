/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.StudentDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.HibernateUtil;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class StudentService {
    private StudentDAOImpl studentDAO;
    private static StudentService instance;
    private HibernateUtil util = HibernateUtil.getHibernateUtil();
    private Session session = util.getSession();
    private Transaction transaction;

    /**
     * Singleton-fabric
     */
    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public StudentService() {
        studentDAO = StudentDAOImpl.getInstance();
    }

    public Student initStudent(User user, int level, double average, int cardId) {
        return (Student) studentDAO.initStudent(user, level, average, cardId);
    }


    public void create(Student student) throws DAOException {
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            User user = UserService.getInstance().getById(student.getIdUser());
          //  Integer id = student.getIdUser();
             session.delete(user);
            studentDAO.create(student);
//            UserService.getInstance().delete(id);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Transaction failed in create student method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create student method", e);
        }
    }

}
