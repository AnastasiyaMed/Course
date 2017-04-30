<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html>
<script type="text/javascript" src="js/validation.js"></script>
<head>
    <script type="text/javascript" src="/js/validation.js"></script>
    <title>Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="color: black;">
    <div class="row">
        <div class="col-md-5">
            <div class="text-center">
                <h3><fmt:message key="Login.Form"/></h3>
                <fmt:message key="locale"/>
            </div>
            <form action="controller" method="POST" class="form-horizontal">
                <input type="hidden" name="command" value="login">
                <div class="form-group">
                    <label for="login"><fmt:message key="Login"/></label> <input name="login"
                                                                                 id="loginForm" type="text"
                                                                                 class="form-control"
                                                                                 placeholder=
                                                                                 <fmt:message key="input.login"/>
                                                                                         onKeyUp="check('login')"> <b
                        id="login" style="color: red; font-size: 10px;"><fmt:message key="check.login"/></b>
                </div>

                <div class="form-group">
                    <label for="password"><fmt:message key="password"/></label> <input name="password"
                                                                                       id="passwordForm" type="text"
                                                                                       class="form-control"
                                                                                       placeholder=
                                                                                       <fmt:message
                                                                                               key="input.password"/>
                                                                                               onKeyUp="check('password')">
                    <b id="password" style="color: red; font-size: 10px;"><fmt:message key="check.password"/></b>
                </div>
                <button type="submit" class="btn btn-primary"><fmt:message key="login.button"/></button>
            </form>


            <br/> ${wrongAction} <br/> ${exceptionMessage} <br/> ${nullPage} <br/> <a
                href="registr.jsp"><fmt:message key="registration"/></a> Links for guest... <br/>
            Debug info - session = ${sessionScope}
        </div>
    </div>
</div>
</body>
</html>