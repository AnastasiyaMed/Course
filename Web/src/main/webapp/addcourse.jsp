<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%request.setCharacterEncoding("UTF-8");%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html>
<script type="text/javascript" src="js/validation.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <script type="text/javascript" src="/js/validation.js"></script>
        <title>New Course Page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="color: black">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
<form name="addcourse" method="POST" action="controller" class="form-horizontal">
    <input type="hidden" name="command" value="addcourse"/>
    <div class="form-group">
    <label for="name"><fmt:message key="course.name"/></label>
     <input name="name" id="nameForm" value="" type="text" class="form-control"
        placeholder="Input name" onKeyUp="check('name')" maxlength="15">
        <b id="name" style="color: red; font-size: 10px;"><fmt:message key="check.name"/></b>                            </div>
    <div class="form-group">
        <label for="duration"><fmt:message key="course.duration"/></label>
        <input type="text" id="cardForm" name="duration" placeholder=
        <fmt:message key="course.duration"/> class="form-control" onKeyUp="check('card')">
        <b id="duration" style="color: red; font-size: 10px;"><fmt:message key="check.card"/></b>
    </div>
    <div class="form-group">
        <label for="auditorium"><fmt:message key="course.auditorium"/></label>
        <input type="text" id="cardForm" name="auditorium" placeholder=
        <fmt:message key="course.auditorium"/> class="form-control" onKeyUp="check('card')">
        <b id="auditorium" style="color: red; font-size: 10px;"><fmt:message key="check.card"/></b>
    </div>
    <br/>
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
    <div class="form-group">
        <button type="submit" class="btn btn-primary"><fmt:message key="course.add"/></button>
    </div>
        </div>
    </div>
</div>
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>

<c:if test="${not empty dataofcourseerror}">
        <div class="text-center">
            <h4>
                <font color="red">${dataofcourseerror}</font>
            </h4>
        </div>
    </c:if>
    <c:if test="${not empty courseexist}">
        <div class="text-center">
            <h4>
                <font color="red">${courseexist}</font>
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