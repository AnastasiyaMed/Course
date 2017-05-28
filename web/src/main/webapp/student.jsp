<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html><head><title>Welcome student!</title></head>
<body>
<h3><fmt:message key="welcome.student"/>!</h3>
<hr/>
${user}, <fmt:message key="hello"/>!
<hr/>
<form name="ShowCourses" method="POST" action="controller">
<input type="hidden" name="command" value="ShowCourses" />
<input type="submit" value="<fmt:message key="course.show"/>"/>
 <c:if test="${not empty  exceptionMessage}">
  <div class="text-center">
   <h4>
    <font color="red">${exceptionMessage}</font>
   </h4>
  </div>
 </c:if>
</form><hr/>
Links for student...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout"><fmt:message key="Logout"/></a>
</body></html>