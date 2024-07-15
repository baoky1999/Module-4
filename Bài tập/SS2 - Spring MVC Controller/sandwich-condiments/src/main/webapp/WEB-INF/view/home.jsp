<%--
  Created by IntelliJ IDEA.
  User: Laptop K1
  Date: 15/07/2024
  Time: 2:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chọn các món ăn kèm</title>
</head>
<body>
<h3>Chọn các đồ ăn kèm với Sandwich</h3>
<form action="sandwich/listMenu" method="post">
    <c:forEach var="item" items="${items}">
    <input type="checkbox" value="${item.item}" name="condiment">${item.item}
    <br>
    </c:forEach>
    <hr>
    <button type="submit">save</button>
</form>
</body>
</html>
