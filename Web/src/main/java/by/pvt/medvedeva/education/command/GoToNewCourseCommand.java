package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToNewCourseCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List <Teacher> teachers;

        try {
            teachers = TeacherService.getInstance().getAll();
            HttpSession session = request.getSession(true);
            request.setAttribute ("teachersList", teachers);
            session.setAttribute("teachersList", teachers);
            page = ConfigurationManager.getProperty("path.page.addcourses");


        } catch (DAOException e) {
            request.setAttribute("exceptionMessage", MessageManager.getProperty("message.exceptionMessage"));
            page = ConfigurationManager.getProperty("path.page.main");
        }
        return page;
    }

}
