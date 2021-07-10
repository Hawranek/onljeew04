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
    <title>Book form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<form:form modelAttribute="book" method="post">
    <form:input path="title"/>
    <form:errors path="title" cssClass="error"/>

    <form:input path="rating"/>
    <form:errors path="rating" cssClass="error"/>

    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <form:errors path="publisher" cssClass="error"/>

    <input type="submit">
</form:form>

</body>
</html>
