<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 27.06.2021
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<form:form modelAttribute="book" method="post">
    <form:hidden path="id"/>
    <tr>
        Tytuł:
        <form:input path="title"/>
        <form:errors path="title" cssClass="error"/>
        <br/>
    </tr>
    <tr>
        Rating:
        <form:input path="rating"/>
        <form:errors path="rating" cssClass="error"/>
        <br/>
    </tr>
    <tr>
        Wydawca:
        <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
        <form:errors path="publisher" cssClass="error"/>
        <br/>
    </tr>
    <tr>
        Autorzy:
        <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/>
        <form:errors path="authors" cssClass="error"/>
        <br/>
    </tr>
    <input type="submit">
</form:form>


<ul>

</ul>
</body>
</html>