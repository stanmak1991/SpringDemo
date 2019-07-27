<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
</head>
<body>
<spring:form modelAttribute="category" action="/edit-category" method="POST">
    <spring:input path="id" hidden="true"/>
    <label for="name">Name</label>
    <spring:input path="name" id="name"/>
    <label for="description">Description</label>
    <spring:input path="description" id="description"/>
    <button type="submit">Submit</button>
</spring:form>

<table  border='1' width='50%'>
    <tr>
        <th>Product name</th>
        <th>Product description</th>
        <th>Product price</th>
    </tr>
    <C:forEach var="p" items="${category.products}">
        <tr>
            <td><c:out value="${p.getName()}"/></td>
            <td><c:out value="${p.getDescription()}"/></td>
            <td><c:out value="${p.getPrice()}"/></td>
        </tr>
    </C:forEach>
</table>
</body>
</html>
