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
    <title>All Authors</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>action</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href='<c:url value="/authors/del/${author.id}"/>'>Usuń</a>
                <a href="<c:url value="/authors/edit/${author.id}"/> ">edytuj</a>

            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="links.jsp"/>
</body>
</html>
