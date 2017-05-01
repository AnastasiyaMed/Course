/**
 *
 */
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;

/**
 * @author Medvedeva Anastasiya
 */
public class TeacherDAOImpl extends AbstractDAO <Teacher> implements TeacherDAO <Teacher> {
    private final static int TEACHER_ROLE = 2;
    private static TeacherDAOImpl instance;

    /**
     * @param connectionPool
     */
    TeacherDAOImpl(ConnectionPool connectionPool) {
        super(Teacher.class);
        this.connectionPool = connectionPool;
    }

    /**
     * Singleton-fabric
     */
    public static TeacherDAOImpl getInstance() {
        if (instance == null) {
            instance = new TeacherDAOImpl((MySQLConnectionPool.getInstance()));
        }
        return instance;
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