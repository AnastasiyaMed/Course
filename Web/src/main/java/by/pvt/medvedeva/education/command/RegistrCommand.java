/**
 * 
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.resource.MessageManager;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import static by.pvt.medvedeva.education.filter.FormDataValidator.*;

/**
 * @author Anastasiya Medvedeva
 *
 */
public class RegistrCommand implements ActionCommand {
	private final String NAME = "name";
	private final String SURNAME = "surname";
	private final String LOGIN = "login";
	private final String PASSWORD = "password";
	private final int ROLE = 0;
	String errMessage = null;

	@Override
	public String execute(HttpServletRequest request) {
		User user = new User();
		UserService userService = new UserService();
		String page = null;
		user.setLogin(request.getParameter(LOGIN).trim());
		user.setName(request.getParameter(NAME).trim());
		user.setSurname(request.getParameter(SURNAME).trim());
		user.setPassword(request.getParameter(PASSWORD).trim());
		user.setRole(ROLE); // по умолчанию 0
		//if ((errMessage = validate(user)) != null) {
		//	request.setAttribute("errorFormDataMessage", validate(user));
		//	return page = ConfigurationManager.getProperty("path.page.registr");
		//}

		if (!userService.checkLogin(user.getLogin())) {
			request.setAttribute("errorRegistrUserMessage", MessageManager.getProperty("message.register.user.error"));
			request.setAttribute("userType", ClientType.GUEST);
			return page = ConfigurationManager.getProperty("path.page.registr");
		} else
			userService.addUser(user);
		HttpSession session = request.getSession(true);
		session.setAttribute("user", request.getParameter(LOGIN));
		session.setAttribute("login", request.getParameter(LOGIN));
		session.setAttribute("isAuthorized", "yes");
		userService.addUser(user);
		session.setAttribute("userType", ClientType.DEFAULT_USER);
		page = ConfigurationManager.getProperty("path.page.defaultuser");

		return page;
	}
}

//	private String validate(User user) {
//		// проверка имени
//		if (!namePattern.matcher(user.getName()).matches()) {
//			// если совпадение не найдено
//			MessageManager.getProperty("message.nameerror");
//		}
//		// проверка фамилии
//		if (!surnamePattern.matcher(user.getSurname()).matches()) {
//			// если совпадение не найдено
//			return MessageManager.getProperty("message.loginregerror");
//		}
//		// проверка логина
//		if (!loginPattern.matcher(user.getLogin()).matches()) {
//			// если совпадение не найдено
//			return MessageManager.getProperty("message.passworderror");
//		}
//		// проверка пароля
//		if (!passwordPattern.matcher(user.getPassword()).matches()) {
//			// если совпадение не найдено
//			return MessageManager.getProperty("message.emailerror");
//		}
//		return null;
//	}
//
//}
