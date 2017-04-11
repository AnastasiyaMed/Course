/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.TeacherDAOImpl;
import by.pvt.medvedeva.education.dao.interfacesDAO.TeacherDAO;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.entity.User;

import java.io.IOException;


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
		Teacher teacher= null;
		try {
			teacher = (Teacher) teacherDAO.initTeacher(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	public void addTeacher(Teacher teacher) {
		TeacherDAOImpl.getInstance().create(teacher);
	}

	public Teacher getTeacher(User user) {
		Teacher teacher = null;
		try {
			teacher = (Teacher) teacherDAO.initTeacher(user);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return teacher;
	}

}
