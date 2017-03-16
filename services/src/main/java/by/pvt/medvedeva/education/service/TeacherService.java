/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.TeacherDAOImpl;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class TeacherService {
	private TeacherDAO teacherDAO;

	public TeacherService() {
		teacherDAO = new TeacherDAOImpl();
	}

	public Teacher initTeacher(User user) {
		return teacherDAO.initTeacher(user);
	}

	public void addTeacher(Teacher teacher) {
		teacherDAO.addTeacher(teacher);
	}

	public Teacher getTeacher(User user) {
		Teacher teacher = teacherDAO.initTeacher(user);

		return teacher;
	}

}
