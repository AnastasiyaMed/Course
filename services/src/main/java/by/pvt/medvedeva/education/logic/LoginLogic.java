package by.pvt.medvedeva.education.logic;

import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.UserService;

import java.io.IOException;


public class LoginLogic {
    private static LoginLogic instance;

    /**
     * Singleton-fabric
     *
     */
    public static LoginLogic getInstance() {
        if (instance == null) {
               instance = new LoginLogic();
         }
        return instance;
    }

    public static int checkUserRole(String enterLogin) {
        User user = null;
        try {
            user = UserService.getInstance().getUser(enterLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int userRole = user.getRole();

        return userRole;
    }

    public static String GetUserPasswordForCheck(String enterLogin) {
        User user = null;
        try {
            user = UserService.getInstance().getUser(enterLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userPassword = user.getPassword();
        return userPassword;
    }

}