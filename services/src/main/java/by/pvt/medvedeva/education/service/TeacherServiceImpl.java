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

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, UserService userService) {
        super(teacherDAO);
    }

}
