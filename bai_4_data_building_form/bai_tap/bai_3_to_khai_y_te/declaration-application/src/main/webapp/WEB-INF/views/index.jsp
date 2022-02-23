<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/21/2022
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">To Khai Y Te</h1>
<form:form action="/index" method="get" modelAttribute="medica">
    <label>Họ và tên(GHI CHỮ IN HOA)(*)</label><br>
    <form:input path="name" cssStyle="width: 100%"/><br>
    <label>Năm sinh</label><br>
    <form:input type="date" path="yearOfBirth" cssStyle="width: 30%"/>
    <label>Giới tính(*)</label>
    <form:select path="gender" cssStyle="width: 30%">
        <form:option value="-Chọn-">-Chọn-</form:option>
        <form:option value="Nam">Nam</form:option>
        <form:option value="Nữ">Nữ</form:option>
    </form:select>
    <label>Quốc gia(*)</label>
    <form:select path="country" cssStyle="width: 20%">
        <form:option value="-Chọn-">-Chọn-</form:option>
        <form:option value="Việt Nam">Nam</form:option>
        <form:option value="America">America</form:option>
        <form:option value="Australia">Australia</form:option>
        <form:option value="China">China</form:option>
    </form:select></br>
</form:form>
</body>
</html>
