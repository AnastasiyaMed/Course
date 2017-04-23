/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.pvt.medvedeva.education.filter;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.entity.User;
import by.pvt.medvedeva.education.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Фильтр исполняет две задачи: кодирует параметры request объекта в UTF-8 и
 * анализирует куки в случае новой сессии.
 *
 * Filter stands for two tasks: encodes request object in UTF-8 and analyses
 * cookies in case of new session.
 *
 */
@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class ConfigFilter implements Filter {
	private static final String ROLE_ATTRIBUT = "role";
	private static final String USER_OBJECT_ATTRIBUTE = "user";
	private static String LOGIN = "login";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// устанавливаем кодировку
		request.setCharacterEncoding("UTF-8");
		try {
			// смотрим куки
			initSession(((HttpServletRequest) request).getSession(), (HttpServletRequest) request);
		} catch (RuntimeException e) {
			request.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (DAOException e) {
			request.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	private void initSession(HttpSession session, HttpServletRequest request) throws DAOException {
		if (session.isNew()) {
			Cookie[] cookies = request.getCookies();
			boolean isFound = false;
			if (cookies != null) {
				for (Cookie c : cookies) {
					// looking for user LOGIN (for authorize purpose)
					if ((c.getName()).equals(LOGIN)) {
						User user = null;
						try {
							UserService.getInstance().getUser(c.getValue());
							} catch (IOException e) {
							request.setAttribute("exeptionMessage", MessageManager.getProperty("message.exceptionMessage"));
													}
						session.setAttribute(ROLE_ATTRIBUT, user.getRole());
						session.setAttribute(USER_OBJECT_ATTRIBUTE, user);

						isFound = true;
					}
				} // end of foreach loop
			} // end of if(cookies != null)
			if (!isFound) {
				session.setAttribute("userType", ClientType.GUEST);
			}
		} // end of if(session)
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
