<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Mail Box Settings</title>
</head>
<body>
<h2>Update Mailbox Settings</h2>

<form:form method="post" modelAttribute="mail" action="/mailbox/update">
    <label for="language">Language:</label>
    <form:select path="language">
        <form:options items="${languages}" />
    </form:select>
    <br><br>

    <label for="size">Page size:</label>
    <form:select path="size">
        <form:options items="${sizes}" />
    </form:select>
    <br><br>

    <label for="spam">Spam filter:</label>
    <form:checkbox path="spam" />
    <br><br>

    <label for="signature">Signature:</label>
    <form:textarea path="signature" />
    <br><br>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
