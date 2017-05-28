<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Welcome admin</title></head>
<body>
<h3><fmt:message key="welcome.admin"/></h3>
<hr/>
${user}, <fmt:message key="hello"/>!

<form name="goToAddCourse" method="POST" action="controller">
    <input type="hidden" name="command" value="GOTOADDCOURSE" />
    <div class="form-group">
        <button type="submit" class="btn btn-primary"><fmt:message key="course.add"/></button>
    </div>
</form><hr/>
<c:if test="${not empty  exceptionMessage}">
    <div class="text-center">
        <h4>
            <font color="red">${exceptionMessage}</font>
        </h4>
    </div>
</c:if>
<c:if test="${not empty courseAdded}">
    <div class="text-center">
        <h4>
            <font color="red">${courseAdded}</font>
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