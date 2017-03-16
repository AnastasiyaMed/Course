package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.resource.ConfigurationManager;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class GetCoursesListCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		UserService userService = new UserService();
		List<Course> list;

		try {
			list = userService.getAllCoursesInfo();
			int listSize = list.size();
			request.setAttribute("list", list);
			request.setAttribute("listSize", listSize);
			page = ConfigurationManager.getProperty("path.page.allcourses");

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return page;
	}
}
