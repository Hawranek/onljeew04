<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 10.07.2021
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publishers</title>
</head>
<body>
<table>
    <th>Nazwa</th>
    <th>NIP</th>
    <th>REGON</th>
    <c:forEach items="${publishers}" var="pub">
        <tr>
            <td>${pub.name}</td>
        </tr>

        <tr>
            <td>${pub.nip}</td>
        </tr>

        <tr>
            <td>${pub.regon}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
