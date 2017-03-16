/**
 * 
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.StudentService;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Anastasiya Medvedeva
 *
 */
public class SetStudentRoleCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из сессии логина
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute(PARAM_NAME_LOGIN);
		StudentService studentService = new StudentService();
		UserService userService = new UserService();
		studentService.addStudent(studentService.initStudent(userService.getUser(login)));
		request.setAttribute("user", login);
		session.setAttribute("userType", ClientType.STUDENT);

		// определение пути к student.jsp
		page = ConfigurationManager.getProperty("path.page.student");

		return page;
	}
}
