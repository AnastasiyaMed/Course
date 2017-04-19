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

/**
 * @author Anastasiya Medvedeva
 *
 */
public class NewCourseCommand implements ActionCommand {

	private final String NAME = "name";
	private final String DURATION = "duration";
	private final String AUDITORIUM = "auditorium";
	private final String TEACHERID = "id";

	@Override
	public String execute(HttpServletRequest request) {

		Course course = new Course();
		UserService userService = new UserService();
		String page = null;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        ClientType type = (ClientType) session.getAttribute("userType");
        if (type == GUEST) {
            page = ConfigurationManager.getProperty("path.page.login");
        }
		if (request.getParameter(TEACHERID).isEmpty()) {
			request.setAttribute("wrongteacherid", MessageManager.getProperty("message.wrongteacherid"));
            page = ConfigurationManager.getProperty("path.page.addcourses");
		} else  if  (TeacherService.getInstance().initTeacherFromBD(Integer.parseInt(request.getParameter(TEACHERID)))== null) {
            request.setAttribute("wrongteacherid", MessageManager.getProperty("message.wrongteacherid"));
			page = ConfigurationManager.getProperty("path.page.addcourses");
			} else {
			course.setName(request.getParameter(NAME).trim());
			course.setDuration(Integer.parseInt(request.getParameter(DURATION).trim()));
			course.setAuditorium(Integer.parseInt(request.getParameter(AUDITORIUM).trim()));
			course.setIdTeacher((Integer.parseInt(request.getParameter(TEACHERID).trim())));
			userService.addNewCourse(course);
			// определение пути к main.jsp
			page = ConfigurationManager.getProperty("path.page.main");
		}
        return page;
	}
}