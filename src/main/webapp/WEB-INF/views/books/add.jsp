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
<body>

<form:form modelAttribute="book" method="post">
    <tr>
        Tytuł:
        <form:input path="title"/>
    </tr>
    <tr>
        Rating:
        <form:input path="rating"/>
    </tr>
    <tr>
        Wydawca:
        <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    </tr>
    <tr>
        Autorzy:
        <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/>
    </tr>
    <input type="submit">
</form:form>


<ul>

</ul>
</body>
<head>
    <title>Title</title>
</head>
</html>