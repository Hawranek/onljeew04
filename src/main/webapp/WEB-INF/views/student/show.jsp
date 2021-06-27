<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Student</title>
</head>
<body>

<p>
    <a href="/student/add">Dodaj nowego studenta</a>
</p>
<p>Imię: ${student.firstName}</p>
<p>Nazwisko: ${student.lastName}</p>
<p>Płeć: ${student.gender}</p>
<p>Kraj: ${student.country}</p>
<p>Notatki: ${student.notes}</p>
<p>Czy chce mailing?: ${student.mailingList}</p>
<p>Umiejętności:
    <c:forEach items="${student.programmingSkills}" var="skill">
        <ul>${skill}</ul>
    </c:forEach>
</p>
<p>Hobby:
    <c:forEach items="${student.hobbies}" var="hobby">
        <ul>${hobby}</ul>
    </c:forEach>
</p></body>
</html>
