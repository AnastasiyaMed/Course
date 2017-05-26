package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.TeacherServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Anastasiya Medvedeva
 */
public class GoToNewCourseCommand implements ActionCommand {
    private static final String TEACHERS_LIST = "teachersList";

    /**
     * @param request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List <Teacher> teachers;
        HttpSession session = request.getSession(true);
        try {
            teachers = TeacherServiceImpl.getInstance().getAll();

            session.setAttribute(TEACHERS_LIST, teachers);
            session.setAttribute("teachersList", teachers);
            page = ConfigurationManager.getProperty("path.page.addcourses");
        } catch (DAOException e) {
            session.setAttribute("exceptionMessage", MessageManager.getProperty("message.exceptionMessage"));
            page = ConfigurationManager.getProperty("path.page.main");
        }
        return page;
    }

}
