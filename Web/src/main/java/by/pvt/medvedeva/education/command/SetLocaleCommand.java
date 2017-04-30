package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetLocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = LocaleManager.getProperty(request.getParameter("locale"));
        session.setAttribute("locale", locale);
//        Cookie c = new Cookie("locale", locale);
//        c.setMaxAge(60 60 24 * 30);
//        response.addCookie(c);
        return request.getHeader("referer");
//       return null;

    }
}
