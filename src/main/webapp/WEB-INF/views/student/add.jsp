<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 27.06.2021
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>

<form:form modelAttribute="student" method="post">
    <p>Imię:<form:input path="firstName"/></p>
    <p> Nazwisko:<form:input path="lastName"/></p>
    <p> Płeć:<form:radiobuttons items="${gender}" path="gender"/></p>
    <p> Kraj:<form:select path="country" items="${countries}"/></p>
    <p> Notatki:<form:textarea path="notes"/></p>
    <p> Czy chcesz otrzymywać powiadomienia?<form:checkbox path="mailingList" value="mailingList"/></p>
    <p> Umiejętności:<form:select path="programmingSkills" items="${skills}" multiple="true"/></p>
    <p> Hobby:<form:checkboxes items="${hobbies}" path="hobbies"/></p>
    <p><input type="submit"></p>
</form:form>

</body>
</html>
