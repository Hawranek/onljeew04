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
</head>
<body>

<form:form modelAttribute="book" method="post">
    <form:input path="title"/>
    <form:input path="rating" />
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <input type="submit">
</form:form>


<ul>

</ul>
</body>
</html>