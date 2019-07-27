<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<spring:form modelAttribute="user" action="add-user" method="POST">
    <input type="text" name="name"/>
    <input type="number" name="age"/>
    <button type="submit">Add</button>
</spring:form>
</body>
</html>
