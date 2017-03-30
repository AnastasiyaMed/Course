/**
 * 
 */
package by.pvt.medvedeva.education.service;

import by.pvt.medvedeva.education.dao.CourseDAOImpl;
import by.pvt.medvedeva.education.dao.UserDAOImpl;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.UserDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class UserService {
	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAOImpl();
	}

	public User getUser(String enterLogin) throws IOException {
		return userDAO.getUserByLogin(enterLogin);
	}

	public void addNewCourse(Course course) {
		CourseDAO courseDAO = new CourseDAOImpl();
		courseDAO.addCourse(course);
	}

	public void addUser(User user)  {

			userDAO.addUser(user);
	}

	public List<Course> getAllCoursesInfo() {
		CourseDAO courseDAO = new CourseDAOImpl();

		return courseDAO.getAllCoursesInfo();
	}

	public boolean checkLogin(String login)  {
		boolean resultCheckLogin = true;
		try {
			resultCheckLogin = userDAO.CheckLogin(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCheckLogin;
	}


	public User setUserByRole(User user, int userRole) {
		User userByRole = null;
		StudentService studserv = new StudentService();
		TeacherService teacherserv = new TeacherService();

		if (userRole == 1) {
			userByRole = studserv.getStudent(user);
		}
		if (userRole == 2) {
			userByRole = teacherserv.getTeacher(user);
		}
		if (userRole == 3) {
			userByRole = user;
		}
		return userByRole;
	}

}
