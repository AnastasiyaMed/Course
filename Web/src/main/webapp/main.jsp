<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome admin</title></head>
<body>
<h3>Welcome, admin</h3>
<hr/>
 ${user}, hello!
<hr/>
Links for admin...<br/>
Debug info - session = ${sessionScope}
<a href="controller?command=logout">Logout</a>
<br/>
<a href="addcourse.jsp" >Add New Course</a>
</body></html>