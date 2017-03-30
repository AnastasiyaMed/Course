/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.StudentDAOImpl;
import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;

import java.io.IOException;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class StudentService {
	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAOImpl();
	}

	public Student initStudent(User user) {
		return studentDAO.initStudent(user);
	}

	public void addStudent(Student student) {
		try {
			studentDAO.addStudent(student);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Student getStudent(User user) {
		Student student = studentDAO.initStudent(user);
				return student;
	}

}
