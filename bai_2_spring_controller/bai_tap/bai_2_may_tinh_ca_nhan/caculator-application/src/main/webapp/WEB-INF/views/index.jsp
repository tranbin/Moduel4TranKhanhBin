<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/17/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator Application</h1>
<form action="/caculator" method="post">
    <input type="text" name="choose1" placeholder="Input number one here">
    <input type="text" name="choose2" placeholder="Input number two here"></br>
    <input type="submit" name="div" value="Addition(+)">
    <input type="submit" name="div" value="Subtraction(-)">
    <input type="submit" name="div" value="Multiplication(X)">
    <input type="submit" name="div" value="Division(/)">
</form>
<h3 style="color: orangered">Result Division :${result}</h3>
</body>
</html>
