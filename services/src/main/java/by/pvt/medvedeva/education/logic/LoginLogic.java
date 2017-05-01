package by.pvt.medvedeva.education.logic;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.UserService;

/**
 * @author Medvedeva Anastasiya
 */
public class LoginLogic {
    private static LoginLogic instance;

    /**
     * Singleton-fabric
     */
    public static LoginLogic getInstance() {
        if (instance == null) {
            instance = new LoginLogic();
        }
        return instance;
    }

    /**
     * @param enterLogin
     * @return userRole
     * @throws DAOException
     */
    public static int checkUserRole(String enterLogin) throws DAOException {
        User user;
        user = UserService.getInstance().getByLogin(enterLogin);
        int userRole = user.getRole();
        return userRole;
    }

    /**
     * @param enterLogin
     * @return userPassword
     * @throws DAOException
     */
    public static String GetUserPasswordForCheck(String enterLogin) throws DAOException {
        User user;
        user = UserService.getInstance().getByLogin(enterLogin);
        String userPassword = user.getPassword();
        return userPassword;
    }

}