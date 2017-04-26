
package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.StudentDAO;
import by.pvt.medvedeva.education.entity.Student;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;


/**
 * @author Medvedeva Anastasiya
 *
 */
public class StudentDAOImpl extends AbstractDAO<Student> implements StudentDAO<Student> {

	private static final String SQL_QUERY_CHANGE_USERROLE = "UPDATE `user` SET `role`='1' WHERE  user.user_id = ?";
	private final static int STUDENT_ROLE = 1;
	private static StudentDAOImpl instance;

	StudentDAOImpl(ConnectionPool connectionPool) {
		super(Student.class);
		this.connectionPool = connectionPool;
	}

	/**
	 * Singleton-fabric
	 *
	 */
	public static StudentDAOImpl getInstance() {
		if (instance == null) {
			instance = new StudentDAOImpl(MySQLConnectionPool.getInstance());
		}
		return instance;
	}

	@Override
	public Student initStudent(User user, int level, double average, int cardId) {
		Student student = new Student();
			student.setName(user.getName());
			student.setSurname(user.getSurname());
			student.setLogin(user.getLogin());
			student.setPassword(user.getPassword());
			student.setRole(STUDENT_ROLE);
			student.setIdUser(user.getIdUser());
			student.setLevel(level);
			student.setAverage(average);
			student.setStudentIdCard(cardId);
		return student;
	}

	}
