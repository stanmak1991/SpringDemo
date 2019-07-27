<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div>
    <c:forEach var="product" items="${products}">
        <h3>Product name <c:out value="${product.name}"/></h3>
        <h4>Product description <c:out value="${product.description}"/></h4>
        <h4>Product category <c:out value="${product.category.name}"/></h4>
        <a href="<c:url value="/edit-product?c_id=${product.id}"/>">Edit</a>
        <a href="<c:url value="/delete-product?c_id=${product.id}"/>">Delete</a>
    </c:forEach>
    <p><a href="<c:url value="/add-product"/>">Add</a></p>
</div>
</body>
</html>
