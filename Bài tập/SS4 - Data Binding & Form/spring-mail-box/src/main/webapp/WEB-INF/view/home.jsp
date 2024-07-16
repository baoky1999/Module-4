<%--
  Created by IntelliJ IDEA.
  User: Laptop K1
  Date: 16/07/2024
  Time: 2:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Mail box</title>
</head>
<body>
    <h3>Language: ${mail.language}</h3>
    <h3>Page size: ${mail.size}</h3>
    <h3>Spam filter: ${mail.spam}</h3>
    <h3>Signature: ${mail.signature}</h3>
    <button type="submit" onclick="window.location.href='mailbox/update'">Edit</button>
</body>
</html>
