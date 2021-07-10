<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 10.07.2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="publisher" method="post">
    <form:hidden path="id"/>

    <form:label path="name">Nazwa</form:label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
    <br/>

    <form:label path="nip">NIP</form:label>
    <form:input path="nip"/>
    <form:errors path="nip" cssClass="error"/>
    <br/>

    <form:label path="regon">REGON</form:label>
    <form:input path="regon"/>
    <form:errors path="regon" cssClass="error"/>
    <br/>

    <input type="submit">


    </form:form>
</body>
</html>
