<%--
  Created by IntelliJ IDEA.
  User: Nastia
  Date: 14.04.2017
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
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
                    <input type="text" name="level" id="level" placeholder="Enter level" class="form-control">
                </div>
                <div class="form-group">
                    <label for="average">AVERAGE</label>
                    <input type="text" name="average" id="average" placeholder="Enter average" class="form-control">
                </div>
                <div class="form-group">
                    <label for="card">NUMBER OF STUDENTS CARD</label>
                    <input type="text" name="card" id="card" placeholder="Enter number of students card" class="form-control">
                </div>
                <div class="form-group">
                    <button type="button"  class="btn btn-primary">Add student</button>
                    <input type="submit" value="Add student"/>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>