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
import java.io.IOException;

/**
 * @author Anastasiya Medvedeva
 *
 */
public class SetStudentRoleCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_AVERAGE = "average";
	private static final String PARAM_NAME_LEVEL = "level";
	private static final String PARAM_NAME_STUDENT_CARD_ID = "card";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if ((request.getParameter(PARAM_NAME_AVERAGE)==null)||(request.getParameter(PARAM_NAME_LEVEL)==null)||(request.getParameter(PARAM_NAME_STUDENT_CARD_ID)==null)){
			page = ConfigurationManager.getProperty("path.page.newStudent");
		} else {
			int level = Integer.parseInt(request.getParameter(PARAM_NAME_LEVEL));
			double average = Double.parseDouble(request.getParameter(PARAM_NAME_AVERAGE));
			int cardId = Integer.parseInt(request.getParameter(PARAM_NAME_STUDENT_CARD_ID));
			// извлечение из сессии логина
			HttpSession session = request.getSession();
			String login = (String) session.getAttribute(PARAM_NAME_LOGIN);
			StudentService studentService = new StudentService();
			UserService userService = new UserService();
			try {
				studentService.addStudent(studentService.initStudent(userService.getUser(login), level, average, cardId));
			} catch (IOException e) {
				e.printStackTrace();
			}
			request.setAttribute("user", login);
			session.setAttribute("userType", ClientType.STUDENT);

			// определение пути к student.jsp
			page = ConfigurationManager.getProperty("path.page.student");
		}

		return page;
	}



//	@Override
//	public String execute(HttpServletRequest request) {
//		String page = null;
//		// извлечение из сессии логина
//		HttpSession session = request.getSession();
//		String login = (String) session.getAttribute(PARAM_NAME_LOGIN);
//		StudentService studentService = new StudentService();
//		UserService userService = new UserService();
//		try {
//			studentService.addStudent(studentService.initStudent(userService.getUser(login)));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		request.setAttribute("user", login);
//		session.setAttribute("userType", ClientType.STUDENT);
//
//		// определение пути к student.jsp
//		page = ConfigurationManager.getProperty("path.page.student");
//
//		return page;
//	}
}
