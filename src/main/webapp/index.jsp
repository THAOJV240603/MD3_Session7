<%--
  Created by IntelliJ IDEA.
  User: thao
  Date: 10/14/2024
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Upload File</h1>
<!--Ảnh và âm thanh-->
<form method="post" action="/upload" enctype="multipart/form-data">
    <label>Tải lên hình ảnh: </label>
    <input type="file" name="image"><br><br>

    <label>Tải lên bài hát: </label>
    <input type="file" name="audio"><br>
    <button type="submit" class="btn btn-primary">Gửi</button>
</form>
</body>
</html>
