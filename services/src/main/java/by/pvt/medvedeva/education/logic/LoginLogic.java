package by.pvt.medvedeva.education.logic;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.UserService;

import java.io.IOException;


public class LoginLogic {

    public static int checkUserRole(String enterLogin) {
        UserService userService = new UserService();
        User user = null;
        try {
            user = userService.getUser(enterLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int userRole = user.getRole();

        return userRole;
    }

    public static String GetUserPasswordForCheck(String enterLogin) {
        UserService userService = new UserService();
        User user = null;
        try {
            user = userService.getUser(enterLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userPassword = user.getPassword();
        return userPassword;
    }

    public boolean checkLogin(String login) {
        UserService userService = new UserService();
        boolean resultChek;

            if (userService.checkLogin(login)) {
                resultChek = true;
            } else {
                resultChek = false;
            }
              return resultChek;
    }
}