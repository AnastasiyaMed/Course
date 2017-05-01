/**
 *
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.pvt.medvedeva.education.filter.FormDataValidator.*;

/**
 * @author Anastasiya Medvedeva
 */
public class RegistrCommand implements ActionCommand {
    private final String NAME = "name";
    private final String SURNAME = "surname";
    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String ERROR_MESSAGE = "errorFormDataMessage";
    private final int ROLE = 0;
    String errMessage = null;

    /**
     * @param request
     * @return
     */
    @Override
    public String execute(HttpServletRequest request) {
        User user = new User();
        String page = null;
        HttpSession session = request.getSession(true);
        user.setLogin(request.getParameter(LOGIN).trim());
        user.setName(request.getParameter(NAME).trim());
        user.setSurname(request.getParameter(SURNAME).trim());
        user.setPassword(request.getParameter(PASSWORD).trim());
        user.setRole(ROLE); // по умолчанию 0
        if ((errMessage = validate(user)) != null) {
            session.setAttribute(ERROR_MESSAGE, validate(user));
            return page = ConfigurationManager.getProperty("path.page.registr");
        }
        try {
            if (UserService.getInstance().checkLogin(user.getLogin())) {
                session.setAttribute("errorRegistrUserMessage", MessageManager.getProperty("message.register.user.error"));
                session.setAttribute("userType", ClientType.GUEST);
                return page = ConfigurationManager.getProperty("path.page.registr");
            } else {
                UserService.getInstance().create(user);

                session.setAttribute("user", request.getParameter(LOGIN));
                session.setAttribute("login", request.getParameter(LOGIN));
                session.setAttribute("isAuthorized", "yes");
                session.setAttribute("userType", ClientType.DEFAULT_USER);
                page = ConfigurationManager.getProperty("path.page.defaultuser");
            }
        } catch (DAOException e) {
            session.setAttribute("exceptionMessage", MessageManager.getProperty("message.exceptionMessage"));
            page = ConfigurationManager.getProperty("path.page.registr");
        }

        return page;
    }

    /**
     * @param user
     * @return
     */
    private String validate(User user) {
        String errMessage = null;
        // проверка имени
        if (!namePattern.matcher(user.getName()).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.nameerror");
        }
        // проверка фамилии
        if (!surnamePattern.matcher(user.getSurname()).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.surnameerror");
        }
        // проверка логина
        if (!loginPattern.matcher(user.getLogin()).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.loginregerror");
        }
        // проверка пароля
        if (!passwordPattern.matcher(user.getPassword()).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.passworderror");
        }
        return errMessage;
    }
}
