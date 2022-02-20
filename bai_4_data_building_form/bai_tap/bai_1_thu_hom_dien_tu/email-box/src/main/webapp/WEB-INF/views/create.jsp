<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/20/2022
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3></br>
<form:form action="/home" modelAttribute="email" method="post">
    <span>Languages </span>
    <form:select path="language">
       <form:option value="English">English</form:option>
       <form:option value="Vietnamese">Vietnamese</form:option>
       <form:option value="Japanese">Japanese</form:option>
       <form:option value="Chinese">Chinese</form:option>
    </form:select></br>
    <span>Page Size</span>
    <span>Show</span>
    <form:select path="pageSize">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select></br>
    <label>Spams filter</label>
    <form:checkbox path="spam" value="Enable spams filter"/>Enable spams filter</br>
    <label>Singature</label>
    <form:textarea path="signature"/></br>
    <input type="submit" value="Update">
    <input type="submit" value="Cancel">
</form:form>
</body>
</html>
