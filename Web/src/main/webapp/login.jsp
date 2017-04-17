<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ include file="uselocale.jsp"%>
<%@ include file="footer.jsp"%>
<html>
<script type="text/javascript" src="js/validation.js"></script>
<head>
<script type="text/javascript" src="/js/validation.js"></script>
<title>Login</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="color: black;">
  <div class="row">
   <div class="col-md-5">
    <div class="text-center">
     <h3>Login Form</h3>
     <h3><fmt:message key="locale"/></h3>
    </div>
    <form action="controller" method="POST" class="form-horizontal">
     <input type="hidden" name="command" value="login">
     <div class="form-group">
      <label for="login">Login</label> <input name="login"
       id="loginForm" type="text" class="form-control"
       placeholder="Input login" onKeyUp="check('login')"> <b
       id="login" style="color: red; font-size: 10px;"> Latin
       letters or digits at least 3 symbols up to 10</b>
     </div>

     <div class="form-group">
      <label for="password">Password</label> <input name="password"
       id="passwordForm" type="text" class="form-control"
       placeholder="Input password" onKeyUp="check('password')">
      <b id="password" style="color: red; font-size: 10px;">Latin
     letters, digits, *, ! or ^ at least 3 symbols up to 13</b>
   </div>
     <button type="submit" class="btn btn-primary">Log in</button>
    </form>
   
   
    <br /> ${wrongAction} <br /> ${nullPage} <br /> <a
     href="registr.jsp">Registration</a> Links for guest... <br />
    Debug info - session = ${sessionScope}
    
    
   </div>
  </div>
 </div>
</body>
</html>