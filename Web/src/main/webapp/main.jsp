<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html>
<head><title>Welcome admin</title></head>
<body>
<h3><fmt:message key="welcome.admin"/></h3>
<hr/>
${user}, <fmt:message key="hello"/>!

<form name="goToAddCourse" method="POST" action="controller">
    <input type="hidden" name="command" value="GOTOADDCOURSE" />
    <input type="submit" value=<fmt:message key="course.add"/>/>
</form><hr/>
<c:if test="${not empty  exceptionMessage}">
    <div class="text-center">
        <h4>
            <font color="red">${exceptionMessage}</font>
        </h4>
    </div>
</c:if>
<hr/>
Links for admin...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout"><fmt:message key="Logout"/></a>
<br/>
</body>
</html>