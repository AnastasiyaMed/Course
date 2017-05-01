package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Anastasiya Medvedeva
 */
public class SetLocaleCommand implements ActionCommand {
    private final String LOCALE = "locale";

    /**
     * @param request
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = LocaleManager.getProperty(request.getParameter(LOCALE));
        session.setAttribute(LOCALE, locale);
        return request.getHeader("referer");

    }
}
