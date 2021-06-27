<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Person</title>
</head>
<body>
<form:form modelAttribute="person">
    <form:input path="login"/>
    <form:password path="password"/>
    <form:input path="email"/>
    <input type="submit">
</form:form>

</body>
</html>
