<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 17:59
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
<form:form modelAttribute="author" method="post">
    <table>
        <th>firstName</th>
        <th>lastName</th>
        <tr>
            <td>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
            </td>

            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </td>
        </tr>
    </table>
    <input type="submit">

</form:form>
<jsp:include page="links.jsp"/>

</body>
</html>
