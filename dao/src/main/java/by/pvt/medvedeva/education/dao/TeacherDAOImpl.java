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
    private final static int TEACHER_ROLE = 2;

    @Autowired
    private TeacherDAOImpl(SessionFactory sessionFactory) {
        super(Teacher.class, sessionFactory);
    }

       /**
     * @param user
     * @return
     */
    @Override
    public Teacher initTeacher(User user) {
        Teacher teacher = new Teacher();
        teacher.setName(user.getName());
        teacher.setSurname(user.getSurname());
        teacher.setLogin(user.getLogin());
        teacher.setPassword(user.getPassword());
        teacher.setRole(TEACHER_ROLE);
        teacher.setIdUser(user.getIdUser());
        return teacher;
    }

}