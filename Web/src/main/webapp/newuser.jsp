<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html><head><title><fmt:message key="hello.new"/></title></head>
<body>
<fmt:message key="hello.new"/>
<form name="loginForm" method="POST" action="controller">
<input type="hidden" name="command" value="login" />
    <fmt:message key="Login"/> <br/>
<input type="text" name="login" value=""/>
<br/><fmt:message key="password"/><br/>
<input type="password" name="password" value=""/>
 <br/>
${errorLoginPassMessage}
 <br/>
${wrongAction}
 <br/>
${nullPage}
 <br/>
<input type="submit" value="Log in"/>
</form><hr/>
Debug info - session = ${sessionScope}
</body></html>