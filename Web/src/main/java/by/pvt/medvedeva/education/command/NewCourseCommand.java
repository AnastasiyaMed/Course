/**
 *
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.dao.exception.DAOException;
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
    private final String USERID = "id";
    private final String USER_TYPE = "userType";
    String errMessage = null;

    /**
     *
     * @param request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        Course course = new Course();
        Teacher teacher;
        HttpSession session = request.getSession();
        ClientType type = (ClientType) session.getAttribute(USER_TYPE);
        if (type == GUEST) {
            page = ConfigurationManager.getProperty("path.page.login");
        } else {
            if ((request.getParameter(NAME).isEmpty())
                    || (request.getParameter(DURATION).isEmpty())
                    || (request.getParameter(AUDITORIUM).isEmpty())
                    || (request.getParameter(USERID).isEmpty())) {
                page = ConfigurationManager.getProperty("path.page.addcourses");
                request.setAttribute("dataofcourseerror", MessageManager.getProperty("message.dataofcourseerror"));
            } else if ((errMessage = validate(request.getParameter(DURATION), request.getParameter(AUDITORIUM), request.getParameter(USERID))) != null) {
                request.setAttribute("errorFormDataMessage", validate((request.getParameter(DURATION)), request.getParameter(AUDITORIUM), request.getParameter(USERID)));
                page = ConfigurationManager.getProperty("path.page.addcourses");
            } else {
                try {
                    teacher = TeacherService.getInstance().getById((Integer.parseInt(request.getParameter(USERID).trim())));
                    course.setName(request.getParameter(NAME).trim());
                    course.setDuration(Integer.parseInt(request.getParameter(DURATION).trim()));
                    course.setAuditorium(Integer.parseInt(request.getParameter(AUDITORIUM).trim()));
                    course.setTeacher(teacher);
                    if (CourseService.getInstance().checkCourseIsExist(course) == false) {
                        CourseService.getInstance().create(course);
                        // определение пути к main.jsp
                        request.setAttribute("courseAdded", MessageManager.getProperty("message.courseadded"));
                        page = ConfigurationManager.getProperty("path.page.main");
                    } else {
                        page = ConfigurationManager.getProperty("path.page.addcourses");
                        request.setAttribute("courseexist", MessageManager.getProperty("courseisalreadyexist"));
                    }
                } catch (DAOException e) {
                    request.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
                    page = ConfigurationManager.getProperty("path.page.addcourses");
                }
            }
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
        if (!teacherIdPattern.matcher(teacherID).matches()) {
            // если совпадение не найдено
            errMessage = MessageManager.getProperty("message.wrongteacherid");
        }
        return errMessage;
    }
}