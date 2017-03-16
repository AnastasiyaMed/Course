package by.pvt.medvedeva.education.logic;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.UserService;

import java.sql.SQLException;


public class LoginLogic {

	public static int checkUserRole(String enterLogin) {
		UserService userService = new UserService();
		User user = userService.getUser(enterLogin);
		int userRole = user.getRole();

		return userRole;
	}

	public static String GetUserPasswordForCheck(String enterLogin) {
		UserService userService = new UserService();
		User user = userService.getUser(enterLogin);
		String userPassword = user.getPassword();
				return userPassword;
	}

	public boolean checkLogin(String login) throws SQLException {
		UserService userService = new UserService();
		return userService.checkLogin(login);
	}

}