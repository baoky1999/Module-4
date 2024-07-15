<%--
  Created by IntelliJ IDEA.
  User: Laptop K1
  Date: 15/07/2024
  Time: 3:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form method="post">
    <label for="first">
        <input type="number" id="first" name="first" placeholder="First Number" required step="any">
    </label>
    <label for="second">
        <input type="number" id="second" name="second" placeholder="Second Number" required step="any">
    </label>
    <button type="submit" value="+" name="item">Addition (+)</button>
    <button type="submit" value="-" name="item">Subtraction (-)</button>
    <button type="submit" value="*" name="item">Multiplication (x)</button>
    <button type="submit" value="/" name="item">Division (/)</button>
</form>
<h2>Result Division: ${result}</h2>
</body>
</html>
