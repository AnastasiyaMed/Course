/**
 *
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.StudentServiceImpl;
import by.pvt.medvedeva.education.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.pvt.medvedeva.education.filter.FormDataValidator.*;

/**
 * @author Anastasiya Medvedeva
 */
public class SetStudentRoleCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_AVERAGE = "average";
    private static final String PARAM_NAME_LEVEL = "level";
    private static final String PARAM_NAME_STUDENT_CARD_ID = "card";
    private static final String NEW_STUDENT_PATH = "path.page.newStudent";
    String errMessage = null;

    /**
     * @param request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        if ((request.getParameter(PARAM_NAME_LEVEL) == null) || (request.getParameter(PARAM_NAME_AVERAGE) == null) || (request.getParameter(PARAM_NAME_STUDENT_CARD_ID) == null)) {
            page = ConfigurationManager.getProperty(NEW_STUDENT_PATH);
        } else if ((errMessage = validate(request.getParameter(PARAM_NAME_LEVEL), request.getParameter(PARAM_NAME_AVERAGE), request.getParameter(PARAM_NAME_STUDENT_CARD_ID))) != null) {
            session.setAttribute("errorFormDataMessage", validate(request.getParameter(PARAM_NAME_LEVEL), request.getParameter(PARAM_NAME_AVERAGE), request.getParameter(PARAM_NAME_STUDENT_CARD_ID)));
            page = ConfigurationManager.getProperty(NEW_STUDENT_PATH);
        } else {
            int level = Integer.parseInt(request.getParameter(PARAM_NAME_LEVEL));
            double average = Double.parseDouble(request.getParameter(PARAM_NAME_AVERAGE));
            int cardId = Integer.parseInt(request.getParameter(PARAM_NAME_STUDENT_CARD_ID));
            // извлечение из сессии логина

            String login = (String) session.getAttribute(PARAM_NAME_LOGIN);
            StudentServiceImpl studentService = StudentServiceImpl.getInstance();
            UserServiceImpl userService = UserServiceImpl.getInstance();
            try {
                studentService.create(studentService.initStudent(userService.getByLogin(login), level, average, cardId));
            } catch (DAOException e) {
                session.setAttribute("exceptionMessage", MessageManager.getProperty("message.exceptionMessage"));
                page = ConfigurationManager.getProperty(NEW_STUDENT_PATH);
            }
            session.setAttribute("user", login);
            session.setAttribute("userType", ClientType.STUDENT);

            // определение пути к student.jsp
            page = ConfigurationManager.getProperty("path.page.student");
        }

        return page;
    }

    private String validate(String level, String average, String card) {
        String errMessage = null;
        // проверка уровня
        if (!levelPattern.matcher(level).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.levelerror");
        }
        // проверка среднего балла
        if (!averagePattern.matcher(average).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.averageerror");
        }
        // проверка номера студенческого билета
        if (!cardPattern.matcher(card).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.carderror");
        }

        return errMessage;
    }

}
