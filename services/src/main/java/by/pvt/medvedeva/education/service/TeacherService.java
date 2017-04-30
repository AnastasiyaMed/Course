/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.TeacherDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.Main;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;

import java.util.List;


/**
 * @author Anastasiya Medvedeva
 */
@Log4j
public class TeacherService extends AbstractService {
    private TeacherDAO teacherDAO;
    private static TeacherService instance;


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
        Teacher teacher = (Teacher) teacherDAO.initTeacher(user);
        return teacher;
    }


    public Teacher getById(Integer id) throws DAOException {
        Teacher teacher;
        try {
            session = util.getSession();
            getTransaction();
            teacher = TeacherDAOImpl.getInstance().getById(id);
            commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in getById method" + e);
            transaction.rollback();
            throw new DAOException(getClass(), "Transaction failed in getById method", e);
        }
        return teacher;
    }


    public void create(Teacher teacher) throws DAOException {
        Integer id = teacher.getIdUser();
        try {
            session = util.getSession();
            getTransaction();
            UserService.getInstance().delete(id);
            TeacherDAOImpl.getInstance().create(teacher);
            commitTransaction();
        } catch (HibernateException e) {
            log.error("Transaction failed in create teacher method" + e);
            transaction.rollback();
            throw new DAOException(Main.class, "Transaction failed in create teacher method", e);
        }
    }


    public List <Teacher> getAll() throws DAOException {
        List <Teacher> teachers;
        session = util.getSession();
        getTransaction();
        teachers = TeacherDAOImpl.getInstance().getAll();
        commitTransaction();
        return teachers;
    }


}
