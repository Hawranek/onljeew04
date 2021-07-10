<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 10.07.2021
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vlidate</title>
</head>
<body>
<table>
  <th>Błędy</th>
  <c:forEach var="v" items="${violations}">
    <tr>
        <td>${v.getPropertyPath()}</td>
        <td>:</td>
        <td>${v.getMessage()}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
