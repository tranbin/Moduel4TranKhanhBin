<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/20/2022
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new Music Song</h1>
<form:form method="post" action="/homePage" modelAttribute="music">
    <span>Name Song</span>
    <form:input path="name"></form:input></br>
    <span>Name Singer</span>
    <form:input path="singer"></form:input></br>
    <span>Name Type Of Song</span>
    <form:input path="typeOf"></form:input></br>
    <span>File up</span>
    <form:select path="fileUp">
        <form:option value="mp3">mp3</form:option>
        <form:option value="wav">wav</form:option>
        <form:option value="ogg">ogg</form:option>
        <form:option value="m4p">m4p</form:option>
        <form:option value="m4p">m4p1</form:option>
    </form:select></br>
    <input type="submit" value="Create">
</form:form>
</body>
</html>
