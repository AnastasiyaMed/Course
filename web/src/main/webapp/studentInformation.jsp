<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>

<html>

<script type="text/javascript" src="js/validation.js"></script>
<head>
    <script type="text/javascript" src="/js/validation.js"></script>
    <meta charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Add information about student</title>
</head>
<body>
<div class="container" style="color: black">
    <div class="row">
        <div class="text-center">
            <h3><fmt:message key="student.info"/></h3>
        </div>
        <div class="col-md-4 col-md-offset-4">
            <form action="controller" method="POST" class="form-horizontal">
                <input type="hidden" name="command" value="addStudent"/>
                <div class="form-group">
                    <label for="level"><fmt:message key="student.level"/></label>
                    <input type="text" id="levelForm" class="form-control" name="level" placeholder="Enter level"
                           onKeyUp="check('level')">
                    <b id="level" style="color: red; font-size: 10px;"><fmt:message key="check.level"/></b>
                </div>
                <div class="form-group">
                    <label for="average"><fmt:message key="average"/></label>
                    <input type="text" id="averageForm" name="average" placeholder=
                    <fmt:message key="average"/> class="form-control" onKeyUp="check('average')">
                    <b id="average" style="color: red; font-size: 10px;"><fmt:message key="check.average"/></b>
                </div>
                <div class="form-group">
                    <label for="card"><fmt:message key="student.card"/></label>
                    <input type="text" id="cardForm" name="card" placeholder=
                    <fmt:message key="student.card"/> class="form-control" onKeyUp="check('card')">
                    <b id="card" style="color: red; font-size: 10px;"><fmt:message key="check.card"/></b>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary"><fmt:message key="student.add"/></button>
                </div>
                <c:if test="${not empty errorFormDataMessage}">
                    <div class="text-center">
                        <h4>
                            <font color="red">${errorFormDataMessage}</font>
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
        </div>
    </div>
</div>
</body>
</html>