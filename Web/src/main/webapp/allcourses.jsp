<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Courses for your choice!</title>
</head>
<body>
	<h3>Welcome, there are all current courses!</h3>
	<hr />
	<h2>Enjoy it:</h2>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="text-center">
					<h3>All Courses</h3>
				</div>

				<table class="table table-striped table-condensed table-bordered">
					<tr>
						<td align="center">№</td>
						<td align="center">Course name</td>
						<td align="center">Course duration</td>
						<td align="center">Course auditorium</td>
					</tr>

					<c:forEach items="${list}" varStatus="сounter">
						<tr>
							<td align="center">${сounter.count}</td>
							<td align="center">${list[сounter.count-1].name}</td>
							<td align="center">${list[сounter.count-1].duration}</td>
							<td align="center">${list[сounter.count-1].auditorium}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<hr />
	Links for student...
	<br /> Debug info - session = ${sessionScope}
	<br />
	<a href="controller?command=logout">Logout</a>
	<br />
	<a href="student.jsp">Return to Student's room</a>
</body>
</html>