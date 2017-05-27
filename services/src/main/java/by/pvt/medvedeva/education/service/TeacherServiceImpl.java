/**
 *
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.interfaces.TeacherService;
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
public class TeacherServiceImpl extends AbstractService <Teacher> implements TeacherService {

    private final TeacherDAO teacherDAO;
    private final UserService userService;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, UserService userService) {
        super(teacherDAO);
        this.teacherDAO = teacherDAO;
        this.userService = userService;
    }


    @Override
    public Teacher initTeacher(User user) {
        Teacher teacher = (Teacher) teacherDAO.initTeacher(user);
        return teacher;
    }


    /**
     * @param teacher
     * @throws DAOException
     */
    @Override
    public void create(Teacher teacher) throws DAOException {
        Integer id = teacher.getIdUser();
        try {
            userService.delete(id);
            teacherDAO.create(teacher);
        } catch (HibernateException e) {
            log.error("Transaction failed in create teacher method" + e);
            throw new DAOException(TeacherServiceImpl.class, "Transaction failed in create teacher method", e);
        }
    }


}
