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
import java.util.List;


/**
 * @author Anastasiya Medvedeva
 *
 */
public class UserService {
	private UserDAO userDAO;

	public UserService() {
		userDAO = UserDAOImpl.getInstance();
	}

	public User getUser(String enterLogin) throws IOException {
		return (User) userDAO.getUserByLogin(enterLogin);
	}

	public void addNewCourse(Course course) {
		CourseDAOImpl.getInstance().create(course);
	}

	public void addUser(User user)  {
    UserDAOImpl.getInstance().create(user);
	}

	public List<Course> getAllCoursesInfo() {
		CourseDAO courseDAO = CourseDAOImpl.getInstance();
		return courseDAO.getAllCoursesInfo();
	}

	public boolean checkLogin(String login)  {
		boolean resultCheckLogin = true;
		resultCheckLogin = userDAO.CheckLogin(login);
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
