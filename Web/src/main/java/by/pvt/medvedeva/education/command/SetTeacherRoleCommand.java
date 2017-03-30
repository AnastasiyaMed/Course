/**
 * 
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.TeacherService;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Anastasiya Medvedeva
 *
 */
public class SetTeacherRoleCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";



	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из сессии логина
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute(PARAM_NAME_LOGIN);
		TeacherService teacherService = new TeacherService();
		UserService userService = new UserService();
		try {
			teacherService.addTeacher(teacherService.initTeacher(userService.getUser(login)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("user", login);
		session.setAttribute("userType", ClientType.TEACHER);


		// определение пути к teacher.jsp
		page = ConfigurationManager.getProperty("path.page.teacher");

		return page;
}
}
