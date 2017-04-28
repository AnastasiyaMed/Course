<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Welcome admin</title></head>
<body>
<h3>Welcome, admin</h3>
<hr/>
${user}, hello!

<form name="goToAddCourse" method="POST" action="controller">
    <input type="hidden" name="command" value="GOTOADDCOURSE" />
    <input type="submit" value="Add New Course"/>
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
<a href="controller?command=logout">Logout</a>
<br/>
</body>
</html>