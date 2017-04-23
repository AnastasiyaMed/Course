/**
 *
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.entity.Teacher;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.CourseService;
import by.pvt.medvedeva.education.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.pvt.medvedeva.education.filter.ClientType.GUEST;
import static by.pvt.medvedeva.education.filter.FormDataValidator.*;

/**
 * @author Anastasiya Medvedeva
 */
public class NewCourseCommand implements ActionCommand {

    private final String NAME = "name";
    private final String DURATION = "duration";
    private final String AUDITORIUM = "auditorium";
    private final String TEACHERID = "id";
    String errMessage = null;

    @Override
    public String execute(HttpServletRequest request) {
        Course course = new Course();
        Teacher teacher = new Teacher();
        String page = null;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        ClientType type = (ClientType) session.getAttribute("userType");
        if (type == GUEST) {
            page = ConfigurationManager.getProperty("path.page.login");
        }
        if ((request.getParameter(NAME).isEmpty()) || (request.getParameter(DURATION).isEmpty())
                || (request.getParameter(AUDITORIUM).isEmpty()) || (request.getParameter(TEACHERID).isEmpty())) {
            page = ConfigurationManager.getProperty("path.page.addcourses");
            request.setAttribute("dataofcourseerror", MessageManager.getProperty("message.dataofcourseerror"));
        } else if ((errMessage = validate(request.getParameter(DURATION), request.getParameter(AUDITORIUM),
                request.getParameter(TEACHERID))) != null) {
            request.setAttribute("errorFormDataMessage", validate((request.getParameter(DURATION)), request.getParameter(AUDITORIUM), request.getParameter(TEACHERID)));
            page = ConfigurationManager.getProperty("path.page.addcourses");
        } else try {
            if (TeacherService.getInstance().getById(Integer.parseInt(request.getParameter(TEACHERID))) == null) {
                request.setAttribute("wrongteacherid", MessageManager.getProperty("message.wrongteacherid"));
                page = ConfigurationManager.getProperty("path.page.addcourses");
            } else {
                teacher = TeacherService.getInstance().getById((Integer.parseInt(request.getParameter(TEACHERID).trim())));
                System.out.println(teacher);
                course.setName(request.getParameter(NAME).trim());
                course.setDuration(Integer.parseInt(request.getParameter(DURATION).trim()));
                course.setAuditorium(Integer.parseInt(request.getParameter(AUDITORIUM).trim()));
                course.setTeacher(teacher);
                System.out.println(course);
                CourseService.getInstance().create(course);
                // определение пути к main.jsp
                page = ConfigurationManager.getProperty("path.page.main");
            }
        } catch (DAOException e) {
            request.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
            page = ConfigurationManager.getProperty("path.page.addcourses");
        }
        return page;
    }


    private String validate(String duration, String auditorium, String teacherID) {
        String errMessage = null;
        // проверка длительности
        if (!durationPattern.matcher(duration).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.durationerror");
        }
        // проверка номера аудитории
        if (!auditoriumPattern.matcher(auditorium).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.auditoriumerror");
        }
        // проверка id преподавателя
        if (!teacherIdPattern.matcher(auditorium).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.wrongteacherid");
        }
        return errMessage;
    }
}