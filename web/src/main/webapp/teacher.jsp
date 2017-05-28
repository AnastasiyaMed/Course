<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html><head><title>Welcome teacher!</title></head>
<body>
<h3><fmt:message key="welcome.teacher"/>!</h3>
<hr/>
 ${user}, <fmt:message key="hello"/>!
<hr/>
Links for teacher...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout"><fmt:message key="Logout"/></a>
</body></html>