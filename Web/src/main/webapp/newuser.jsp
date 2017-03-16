<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title></head>
<body>
  hello, you can log in now!
<form name="loginForm" method="POST" action="controller">
<input type="hidden" name="command" value="login" />
Login:<br/>
<input type="text" name="login" value=""/>
<br/>Password:<br/>
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