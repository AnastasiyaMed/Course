<%--
  Created by IntelliJ IDEA.
  User: Nastia
  Date: 14.04.2017
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<script type="text/javascript" src="js/validation.js"></script>
<head>
    <script type="text/javascript" src="/js/validation.js"></script>
    <meta charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Add information about student</title>
</head>
<body>
<div class="container" style="color: black">
    <div class="row">
        <div class="text-center">
            <h3>Введите требуемые данные</h3>
        </div>
        <div class="col-md-4 col-md-offset-4">
            <form action="controller" method="POST" class="form-horizontal">
                <input type="hidden" name="command" value="addStudent" />
                <div class="form-group">
                    <label for="level">LEVEL</label>
                    <input type="text" id="levelForm" class="form-control" name="level"  placeholder="Enter level" onKeyUp="check('level')">
                    <b id="level" style="color: red; font-size: 10px;">Only one number from 1 to 6</b>
                </div>
                <div class="form-group">
                    <label for="average">AVERAGE</label>
                    <input type="text" id="averageForm" name="average"  placeholder="Enter average" class="form-control" onKeyUp="check('average')">
                    <b id="average" style="color: red; font-size: 10px;">It can be decimal number from 1 to 10</b>
                </div>
                <div class="form-group">
                    <label for="card">NUMBER OF STUDENTS CARD</label>
                    <input type="text" id="cardForm" name="card" placeholder="Enter number of students card" class="form-control" onKeyUp="check('card')">
                    <b id="card" style="color: red; font-size: 10px;">Only numbers</b>
                </div>
                <div class="form-group">
                    <button type="submit"  class="btn btn-primary">Add student</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>