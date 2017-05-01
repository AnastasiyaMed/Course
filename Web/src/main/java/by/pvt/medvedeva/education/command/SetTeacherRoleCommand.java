/**
 *
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.TeacherService;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Anastasiya Medvedeva
 */
public class SetTeacherRoleCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String EXCEPTION = "exceptionMessage";

    /**
     *
     * @param request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из сессии логина
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute(PARAM_NAME_LOGIN);
        TeacherService teacherService = TeacherService.getInstance();
        UserService userService = UserService.getInstance();
        try {
            teacherService.create(teacherService.initTeacher(userService.getByLogin(login)));
        } catch (DAOException e) {
            request.setAttribute(EXCEPTION, MessageManager.getProperty("message.exceptionMessage"));
            page = ConfigurationManager.getProperty("path.page.defaultuser");
        }
        request.setAttribute("user", login);
        session.setAttribute("userType", ClientType.TEACHER);


        // определение пути к teacher.jsp
        page = ConfigurationManager.getProperty("path.page.teacher");

        return page;
    }
}
