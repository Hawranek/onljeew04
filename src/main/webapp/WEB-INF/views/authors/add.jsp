<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<form:form modelAttribute="author" method="post">
    <table>
        <th>firstName</th>
        <th>lastName</th>
        <tr>
            <td><form:input path="firstName"/></td>
            <td><form:input path="lastName"/></td>
        </tr>
    </table>
<input type="submit">

</form:form>
<jsp:include page="links.jsp"/>

</body>
</html>
