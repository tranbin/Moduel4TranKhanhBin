<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/17/2022
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="get" action="/save">
    <input type="checkbox" name="choose" value="Lettuce">
    <label>Lettuce</label>
    <input type="checkbox" name="choose" value="Tomato">
    <label>Tomato</label>
    <input type="checkbox" name="choose" value="Mustard">
    <label>Mustard</label>
    <input type="checkbox" name="choose" value="Sprouts">
    <label>Sprouts</label><br>
    <input type="submit" value="Save">
</form>
<c:forEach items="${choose}" var="eat">
    <h4 style="color: darksalmon">You choose: ${eat}</h4>
</c:forEach>

</body>
</html>
