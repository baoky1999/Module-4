<%--
  Created by IntelliJ IDEA.
  User: Laptop K1
  Date: 10/07/2024
  Time: 8:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Danh sách khách hàng</h1>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Thêm mới
    </button><br/>
    <form action="customers?action=search" method="post">
        <label for="productType">Danh sách top:</label>
        <select id="productType" name="choice">
            <option value="">-- chọn --</option>
            <option value="3">3</option>
            <option value="5">5</option>
            <option value="7">7</option>
        </select>
        <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
    </form><br>
    <p>Sản phẩm được đặt hàng nhiều nhất:<span><button type="button" class="btn btn-outline-primary">Xem danh sách</button></span></p>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customer}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="customers?action=add" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thêm sản phẩm mới</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <label for="name" class="form-label">Enter Name:</label>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="name" name="name" aria-describedby="basic-addon3" required>
                        </div>
                        <label for="price" class="form-label" style="margin-top: 20px">Enter Price:</label>
                        <div class="input-group mb-3">
                            <input type="number" class="form-control" id="price" aria-describedby="basic-addon3" name="price" min="100" step="1" required>
                        </div>
                        <label for="discount">Discount:</label>
                        <select id="discount" name="discount" required>
                            <option value="">choice discount</option>
                            <option value="1">5%</option>
                            <option value="2">10%</option>
                            <option value="3">15%</option>
                            <option value="4">20%</option>
                        </select><br>
                        <label for="stock" class="form-label" style="margin-top: 20px">Enter Stock:</label>
                        <div class="input-group mb-3">
                            <input type="number" class="form-control" id="stock" aria-describedby="basic-addon3" name="stock" min="10" step="1" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
