/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.TeacherDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
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
public class TeacherService {
    private TeacherDAO teacherDAO;
    private static TeacherService instance;
    private static HibernateUtil util = HibernateUtil.getHibernateUtil();
    private static Session session;
    private static Transaction transaction;

    /**
     * Singleton-fabric
     */
    public static TeacherService getInstance() {
        if (instance == null) {
            instance = new TeacherService();
        }
        return instance;
    }

    public TeacherService() {
        teacherDAO = TeacherDAOImpl.getInstance();
    }

    public Teacher initTeacher(User user) {
        Teacher teacher = null;
        teacher = (Teacher) teacherDAO.initTeacher(user);
        return teacher;
    }



    public Teacher getById(Integer id) throws DAOException {
        Teacher teacher = new Teacher();
        try {
            session = util.getSession();
            transaction = session.beginTransaction();
            teacher = TeacherDAOImpl.getInstance().getById(id);
            transaction.commit();

        } catch (HibernateException e) {
            log.error("Transaction failed in getById method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in getById method", e);
        }

        return teacher;
    }

    public void addTeacher(Teacher teacher) throws DAOException {
        TeacherDAOImpl.getInstance().create(teacher);
    }

}
