<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="uselocale.jsp" %>
<%@ include file="footer.jsp" %>
<html><head><title>welcome page</title></head>
<body>
<hr/>
 ${user}, <fmt:message key="hello"/>!
 <hr/>
<fmt:message key="choice.role"/>

<form name="SetRole" method="POST" action="controller">
<input type="hidden" name="command" value="addteacher" />
<input type="submit" value=<fmt:message key="teacher"/> />
</form><hr/>
<form name="SetRole" method="POST" action="controller">
<input type="hidden" name="command" value="addstudent"/>
<input type="submit" value=<fmt:message key="student"/> />
</form><hr/>
<a href="login.jsp" ><fmt:message key="return"/></a>
 <br/>
 <br/>
${wrongAction}
 <br/>
${nullPage}
 <br/>
${exceptionMessage}
<br/>
Links for guest...<br/>
Debug info - session = ${sessionScope}
</body></html>