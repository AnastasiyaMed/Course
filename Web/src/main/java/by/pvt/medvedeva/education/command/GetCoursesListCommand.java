package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exception.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.CourseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.pvt.medvedeva.education.filter.ClientType.GUEST;
/**
 * @author Anastasiya Medvedeva
 */
public class GetCoursesListCommand implements ActionCommand {
    /**
     *
     * @param request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List <Course> list;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        ClientType type = (ClientType) session.getAttribute("userType");
        if (type == GUEST) {
            page = ConfigurationManager.getProperty("path.page.login");
        } else {
            try {
                list = CourseServiceImpl.getInstance().getAll();
                int listSize = list.size();
                session.setAttribute("list", list);
                session.setAttribute("listSize", listSize);
                page = ConfigurationManager.getProperty("path.page.allcourses");
            } catch (DAOException e) {
                session.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
                page = ConfigurationManager.getProperty("path.page.student");
            }
        }
        return page;
    }
}
