<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<html><head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Registration</title></head>
<body>
<form name="addcourse" method="POST" action="controller">
<input type="hidden" name="command" value="addcourse" />
Courses Name:<br/>
<input  name="name" value=""/>
<br/>Courses duration (h):<br/>
<input  name="duration" value=""/>
<br/>Auditorium:<br/>
<input  name="auditorium" value=""/>
<br/>Teachers ID:<br/>
<input  name="id" value=""/>
<br/>
<br/>

 <br/>
${errorOfCourseAddingMessage}
 <br/>
${wrongAction}
 <br/>
${nullPage}
 <br/>
  <input type="submit" value="Add Course"/>
</form><hr/>

<br/>
<a href="controller?command=logout">Logout</a>
<br/>
<a href="main.jsp" >Return to Admins room</a>
Links for admin...<br/>
Debug info - session = ${sessionScope}
</body></html>