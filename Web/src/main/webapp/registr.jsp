<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<script type="text/javascript" src="js/validation.js"></script>
<head>
<script type="text/javascript" src="/js/validation.js"></script>
<meta charset="utf-8">
<title>Registration</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <div class="container" style="color: black;">
  <div class="row">
   <div class="col-md-5">
    <div class="text-center">
     <h3>Registr Form</h3>
    </div>
    <form action="controller" method="POST" class="form-horizontal">
     <input type="hidden" name="command" value="registr">
     <div class="form-group">
      <label for="name">Name</label> <input name="name" id="nameForm"
       type="text" class="form-control" placeholder="Input name"
       onKeyUp="check('name')" maxlength="15"> <b id="name"
       style="color: red; font-size: 10px;"> Only latin or only
       russian letters up to 15 symbols</b>
     </div>
     <div class="form-group">
      <label for="surname">Surname</label> <input name="surname"
       id="surnameForm" type="text" class="form-control"
       placeholder="Input surname" onKeyUp="check('surname')"
       maxlength="15"> <b id="surname"
       style="color: red; font-size: 10px;"> Only latin or only
       russian letters up to 15 symbols</b>
     </div>
     <div class="form-group">
      <label for="login">Login</label> <input name="login"
       id="loginForm" type="text" class="form-control"
       placeholder="Input login" onKeyUp="check('login')"> <b
       id="login" style="color: red; font-size: 10px;">Latin letters
       or digits at least 3 symbols up to 10</b>
     </div>
     <div class="form-group">
      <label for="password">Password</label> <input name="password"
       id="passwordForm" type="password" class="form-control"
       placeholder="Input password" onKeyUp="check('password')">
      <b id="password" style="color: red; font-size: 10px;"> Latin
       letters, digits, *, ! or ^ at least 6 symbols up to 15</b>
     </div>
     <button type="submit" class="btn btn-primary">
      Registration</button>

     <c:if test="${not empty errorRegistrUserMessage}">
      <div class="text-center">
       <h4>
        <font color="red">${errorRegistrUserMessage}</font>
       </h4>
      </div>
     </c:if>

    </form>
   </div>

  </div>
 </div>





 <br /> ${errorRegistrationMessage}
 <br /> ${wrongAction}
 <br /> ${nullPage}
 <br /> Links for guest...
 <br /> Debug info - session = ${sessionScope}



</body>
</html>