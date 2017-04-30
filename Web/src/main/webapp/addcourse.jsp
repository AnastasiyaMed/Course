<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>New Course Page</title></head>
<body>
<form name="addcourse" method="POST" action="controller">
    <input type="hidden" name="command" value="addcourse"/><fmt:message key="course.name"/><br/>
    <input name="name" value=""/>
    <br/><fmt:message key="course.duration"/><br/>
    <input name="duration" value=""/>
    <br/><fmt:message key="course.auditorium"/><br/>
    <input name="auditorium" value=""/>
    <div class="form-group">
      <%--@declare id="id"--%><label for="id"><fmt:message key="course.teachers"/></label>
        <div class="col-sm-9">
        <select class="form-control" name="id">
            <c:forEach items="${teachersList}" var="teacher">
                <option value="${teacher.idUser}">${teacher.surname}</option>
            </c:forEach>
        </select>
    </div>
    </div>
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value=<fmt:message key="course.add"/> </label> />

    <c:if test="${not empty dataofcourseerror}">
        <div class="text-center">
            <h4>
                <font color="red">${dataofcourseerror}</font>
            </h4>
        </div>
    </c:if>
    <c:if test="${not empty errorFormDataMessage}">
        <div class="text-center">
            <h4>
                <font color="red">${errorFormDataMessage}</font>
            </h4>
        </div>
    </c:if>
    <c:if test="${not empty wrongteacherid}">
        <div class="text-center">
            <h4>
                <font color="red">${wrongteacherid}</font>
            </h4>
        </div>
    </c:if>
    <c:if test="${not empty exceptionMessage}">
        <div class="text-center">
            <h4>
                <font color="red">${exceptionMessage}</font>
            </h4>
        </div>
    </c:if>
</form>
<hr/>

<br/>
<a href="controller?command=logout"><fmt:message key="Logout"/></a>
<br/>
<a href="main.jsp"><fmt:message key="admin.return"/></a>
Links for admin...<br/>
Debug info - session = ${sessionScope}
</body>
</html>