package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
/**
 * @author Anastasiya Medvedeva
 */
public class LogoutCommand implements ActionCommand {
	/**
	 *
	 * @param request
	 * @return page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		// уничтожение сессии
		request.getSession().invalidate();
		return page;
	}
}