<%--
  Created by IntelliJ IDEA.
  User: Laptop K1
  Date: 12/07/2024
  Time: 2:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Dictionary</h1>
    <form action="dictionary" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Enter English:</label>
            <input type="text" class="form-control" style="width: 300px" id="exampleInputEmail1" name="english" aria-describedby="emailHelp" placeholder="English">
        </div>
        <button type="submit" class="btn btn-primary">Pandemic</button>
    </form>
    <h3>Result: ${word}</h3>
    <h3>${message}</h3>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>

