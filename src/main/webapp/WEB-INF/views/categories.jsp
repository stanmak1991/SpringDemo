<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<div>
    <c:forEach var="c" items="${categories}">
        <h3>Category name: <c:out value="${c.name}"/></h3>
        <h4>Category description: <c:out value="${c.description}"/></h4>
        <a href="<c:url value="/edit-category?c_id=${c.id}"/>">Edit</a>
        <a href="<c:url value="/delete-category?c_id=${c.id}"/>">Delete</a>
    </c:forEach>
    <br>
    <a href="<c:url value="/add-category"/>">Add</a>
</div>
</body>
</html>
