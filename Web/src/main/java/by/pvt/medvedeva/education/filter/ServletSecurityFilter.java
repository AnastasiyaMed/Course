//package by.pvt.medvedeva.education.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//import static by.pvt.medvedeva.education.filter.ClientType.GUEST;
//
//@WebFilter(dispatcherTypes = {
//        DispatcherType.REQUEST,
//        DispatcherType.FORWARD,
//        DispatcherType.INCLUDE,
//}, urlPatterns = {"/controller", "*.jsp"}, servletNames = {"Controller"})
//public class ServletSecurityFilter implements Filter {
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//        ClientType type = (ClientType) session.getAttribute("userType");
//
//        if ((type == null)) {
//            type = GUEST;
//            session.setAttribute("userType", type);
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//            return;
//        }
//            chain.doFilter(request, response);
//
//    }
//
//    @Override
//    public void init(FilterConfig fConfig) throws ServletException {
//    }
//}
