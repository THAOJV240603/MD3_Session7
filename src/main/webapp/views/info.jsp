<%--
  Created by IntelliJ IDEA.
  User: thao
  Date: 10/13/2024
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin đăng ký</title>
</head>
<body>
<ul>
    <li>Họ tên: ${formRegister.firstName} ${formRegister.lastName}</li>
    <li>Email: ${formRegister.email}</li>
    <li>Password: ${formRegister.password}</li>
</ul>
</body>
</html>
