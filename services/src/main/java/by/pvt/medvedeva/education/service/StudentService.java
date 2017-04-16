/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.StudentDAOImpl;
import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class StudentService {
	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = StudentDAOImpl.getInstance();
	}

	public Student initStudent(User user, int level, double average, int cardId) {
		return (Student) studentDAO.initStudent(user,  level, average, cardId);
	}

	public void addStudent(Student student) {
		StudentDAOImpl.getInstance().create(student);
	}

	public Student getStudent(User user, int level, double average, int cardId) {
		Student student = (Student) studentDAO.initStudent(user,  level, average, cardId);
				return student;
	}
	public Student getStudentFromBD(User user) {
		Student student = (Student) studentDAO.initStudentFromBD(user);
		return student;
	}
}
