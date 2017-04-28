package by.pvt.medvedeva.education.filter;

import by.pvt.medvedeva.education.utils.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "SessionClosingFilter", servletNames = "Controller")
@WebFilter (dispatcherTypes = {
       DispatcherType.REQUEST,
  //      DispatcherType.FORWARD,
//        DispatcherType.INCLUDE,
}, urlPatterns = {"/controller"}, servletNames = {"Controller"})
public class SessionClosingFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {}
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        Session session = HibernateUtil.getHibernateUtil().getSession();
        chain.doFilter(req, response);
        HibernateUtil.getHibernateUtil().releaseSession(session);
    }

}
