<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete?</title>
</head>
<body>
<form>
  Czy jesteś pewien, że chcesz usunąć książkę?
  <td>
    <a href='<c:url value="/book-form/delete/${book.id}"/>'>Tak</a>
  </td>
  <td>
    <a href='<c:url value="/book-form/all"/>'>Nie</a>
  </td>
</form>
</body>
</html>
