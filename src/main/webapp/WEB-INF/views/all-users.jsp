<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div>
    <c:forEach var="user" items="${users}">
        <h4>First name: <c:out value="${user.firstName}"/></h4>
        <h4>Last name: <c:out value="${user.lastName}"/></h4>
        <h4>E-mail: <c:out value="${user.email}"/></h4>
        <h4>Roles:</h4>
        <c:forEach var="role" items="${user.roles}">
            <h5><c:out value="${role.name}"/></h5>
        </c:forEach>
        <a href="<c:url value="/edit-user?c_id=${user.id}"/>">Edit</a>
        <a href="<c:url value="/delete-user?c_id=${user.id}"/>">Delete</a>
        <br>
    </c:forEach>
    <br>
    <a href="<c:url value="/add-user"/>">Add</a>
</div>
</body>
</html>
