<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="book" method="post">
    <form:input path="title"/>
    <form:input path="rating"/>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <input type="submit">
</form:form>

</body>
</html>
