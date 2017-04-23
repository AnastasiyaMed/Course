package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.logic.LoginLogic;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private final static int ADMIN_ROLE = 3;
    private final static int TEACHER_ROLE = 2;
    private final static int STUDENT_ROLE = 1;
    private final static int DEFAULT_USER_ROLE = 0;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        UserService userService = new UserService();
        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            if (userService.checkLogin(login)) {
                // проверка логина и пароля
                if ((LoginLogic.checkUserRole(login) == ADMIN_ROLE) && (LoginLogic.GetUserPasswordForCheck(login).equals(pass))) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", login);
                    session.setAttribute("login", login);
                    session.setAttribute("userType", ClientType.ADMINISTRATOR);
                    // определение пути к main.jsp
                    page = ConfigurationManager.getProperty("path.page.main");
                } else if ((LoginLogic.checkUserRole(login) == TEACHER_ROLE) && (LoginLogic.GetUserPasswordForCheck(login).equals(pass))) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", login);
                    session.setAttribute("userType", ClientType.TEACHER);
                    // определение пути к teacher.jsp
                    page = ConfigurationManager.getProperty("path.page.teacher");
                } else if ((LoginLogic.checkUserRole(login) == STUDENT_ROLE) && (LoginLogic.GetUserPasswordForCheck(login).equals(pass))) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", login);
                    session.setAttribute("login", login);
                    session.setAttribute("userType", ClientType.STUDENT);
                    // определение пути к student.jsp
                    page = ConfigurationManager.getProperty("path.page.student");
                } else if ((LoginLogic.checkUserRole(login) == DEFAULT_USER_ROLE) && (LoginLogic.GetUserPasswordForCheck(login).equals(pass))) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", login);
                    session.setAttribute("login", login);
                    session.setAttribute("userType", ClientType.DEFAULT_USER);
                    // определение пути к defaultuser.jsp
                    page = ConfigurationManager.getProperty("path.page.defaultuser");
                }
            } else {
                request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
                request.getSession().setAttribute("userType", ClientType.GUEST);
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } catch (DAOException e) {
            request.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
            page = ConfigurationManager.getProperty("path.page.login");
        }


        return page;
    }
}
