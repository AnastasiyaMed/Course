/**
 * 
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.filter.ClientType;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.TeacherService;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.pvt.medvedeva.education.filter.ClientType.GUEST;
import static by.pvt.medvedeva.education.filter.FormDataValidator.auditoriumPattern;
import static by.pvt.medvedeva.education.filter.FormDataValidator.durationPattern;
import static by.pvt.medvedeva.education.filter.FormDataValidator.teacherIdPattern;

/**
 * @author Anastasiya Medvedeva
 *
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
        String page = null;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        ClientType type = (ClientType) session.getAttribute("userType");
        if (type == GUEST) {
            page = ConfigurationManager.getProperty("path.page.login");
        }
        if ((request.getParameter(NAME).isEmpty()) || (request.getParameter(DURATION).isEmpty()) || (request.getParameter(AUDITORIUM).isEmpty()) || (request.getParameter(TEACHERID).isEmpty())) {
            page = ConfigurationManager.getProperty("path.page.addcourses");
            request.setAttribute("dataofcourseerror", MessageManager.getProperty("message.dataofcourseerror"));
        } else if ((errMessage = validate(request.getParameter(DURATION), request.getParameter(AUDITORIUM), request.getParameter(TEACHERID))) != null) {
            request.setAttribute("errorFormDataMessage", validate((request.getParameter(DURATION)), request.getParameter(AUDITORIUM), request.getParameter(TEACHERID)));
            page = ConfigurationManager.getProperty("path.page.addcourses");
        } else if (TeacherService.getInstance().initTeacherFromBD(Integer.parseInt(request.getParameter(TEACHERID))) == null) {
            request.setAttribute("wrongteacherid", MessageManager.getProperty("message.wrongteacherid"));
            page = ConfigurationManager.getProperty("path.page.addcourses");
        } else {
            course.setName(request.getParameter(NAME).trim());
            course.setDuration(Integer.parseInt(request.getParameter(DURATION).trim()));
            course.setAuditorium(Integer.parseInt(request.getParameter(AUDITORIUM).trim()));
            course.setIdTeacher((Integer.parseInt(request.getParameter(TEACHERID).trim())));
            UserService.getInstance().addNewCourse(course);
            // определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
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