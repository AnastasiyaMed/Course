<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome student!</title></head>
<body>
<h3>Welcome, student!</h3>
<hr/>
 ${user}, hello!
<hr/>
<form name="ShowCourses" method="POST" action="controller">
<input type="hidden" name="command" value="ShowCourses" />
<input type="submit" value="Show all courses"/>
</form><hr/>
Links for student...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout">Logout</a>
</body></html>