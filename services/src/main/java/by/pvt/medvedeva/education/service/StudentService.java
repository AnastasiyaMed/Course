/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.StudentDAOImpl;
import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class StudentService {
	private StudentDAO studentDAO;
	private static StudentService instance;

	/**
	 * Singleton-fabric
	 *
	 */
	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public StudentService() {
		studentDAO = StudentDAOImpl.getInstance();
	}

	public Student initStudent(User user, int level, double average, int cardId) {
		return (Student) studentDAO.initStudent(user,  level, average, cardId);
	}

	public void addStudent(Student student) throws DAOException {
		StudentDAOImpl.getInstance().create(student);
	}

		Student getStudentFromBD(User user) throws DAOException {
		Student student = (Student) studentDAO.initStudentFromBD(user);
		return student;
	}
}
