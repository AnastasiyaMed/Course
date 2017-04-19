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
	private static UserService instance;

	/**
	 * Singleton-fabric
	 *
	 */
	public static  UserService getInstance() {
		if (instance == null) {
			instance = new  UserService();
		}
		return instance;
	}

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
		return  courseDAO.getAllCoursesInfo();
	}

	public boolean checkLogin(String login)  {
		boolean resultCheckLogin = true;
		resultCheckLogin = userDAO.CheckLogin(login);
		return resultCheckLogin;
	}

}
