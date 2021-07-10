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
    <title>Delete Author</title>
</head>
<body>
<table>
    <thead>Czy na pewno chcesz usunąć poniższego autora?</thead>
    <tr>
        <td>Imię:</td>
        <td>${author.firstName}</td>
    </tr>
    <tr>
        <td>Nazwisko:</td>
        <td>${author.lastName}</td>
    </tr>
    <a href='<c:url value="/authors/delete/${author.id}"/>'>Tak</a>

    <tr>
        <a href='<c:url value="/authors/all"/>'>Nie</a>
    </tr>
</table>

<jsp:include page="links.jsp"/>
</body>
</html>
