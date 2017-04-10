/**
 * 
 */
package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.filter.MessageManager;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;

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

		if ((Integer.parseInt(request.getParameter(TEACHERID)) < 1) || Integer.parseInt(request.getParameter(TEACHERID)) > 5) {
			request.setAttribute("errorOfCourseAddingMessage", MessageManager.getProperty("message.addcourseererror"));
			page = ConfigurationManager.getProperty("path.page.registr");
			return page;
		} else {

			course.setName(request.getParameter(NAME).trim());
			course.setDuration(Integer.parseInt(request.getParameter(DURATION).trim()));

			course.setAuditorium(Integer.parseInt(request.getParameter(AUDITORIUM).trim()));

			course.setIdTeacher((Integer.parseInt(request.getParameter(TEACHERID).trim())));

			userService.addNewCourse(course);

			// определение пути к main.jsp
			page = ConfigurationManager.getProperty("path.page.main");

			return page;
		}
	}
}