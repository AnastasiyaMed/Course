/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.TeacherDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class TeacherService {
	private TeacherDAO teacherDAO;
	private static TeacherService instance;

	/**
	 * Singleton-fabric
	 *
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
		Teacher teacher= null;
		teacher = (Teacher) teacherDAO.initTeacher(user);
		return teacher;
	}

	public Teacher initTeacherFromBD(int idTeacher) throws DAOException {
		Teacher teacher= null;
		teacher = (Teacher) teacherDAO.initTeacherFromBD(idTeacher);
		return teacher;
	}


	public void addTeacher(Teacher teacher) throws DAOException {
		TeacherDAOImpl.getInstance().create(teacher);
	}

}
