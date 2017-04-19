<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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


${wrongAction}
 <br/>
${nullPage}
 <br/>
  <input type="submit" value="Add Course"/>
<c:if test="${not empty dataofcourseerror}">
 <div class="text-center">
  <h4>
   <font color="red">${dataofcourseerror}</font>
  </h4>
 </div>
</c:if>
 <c:if test="${not empty errorFormDataMessage}">
  <div class="text-center">
   <h4>
    <font color="red">${errorFormDataMessage}</font>
   </h4>
  </div>
 </c:if>
 <c:if test="${not empty wrongteacherid}">
 <div class="text-center">
  <h4>
   <font color="red">${wrongteacherid}</font>
  </h4>
 </div>
</c:if>
 <c:if test="${not empty exeptionMessage}">
  <div class="text-center">
   <h4>
    <font color="red">${exeptionMessage}</font>
   </h4>
  </div>
 </c:if>

 </form><hr/>

<br/>
<a href="controller?command=logout">Logout</a>
<br/>
<a href="main.jsp" >Return to Admins room</a>
Links for admin...<br/>
Debug info - session = ${sessionScope}
</body></html>