<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>welcome page</title></head>
<body>
<hr/>
 ${user}, hello!
 <hr/>
 Are you teacher or student?
<form name="SetRole" method="POST" action="controller">
<input type="hidden" name="command" value="addteacher" />
<input type="submit" value="Teacher"/>
</form><hr/>
<form name="SetRole" method="POST" action="controller">
<input type="hidden" name="command" value="addstudent" />
<input type="submit" value="Student"/>
</form><hr/>
<a href="login.jsp" >Return</a>
 <br/>
 <br/>
${wrongAction}
 <br/>
${nullPage}
 <br/>
Links for guest...<br/>
Debug info - session = ${sessionScope}
</body></html>