<%--
  Created by IntelliJ IDEA.
  User: thao
  Date: 10/14/2024
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tệp đã tải lên</title>
</head>
<body>
<h1>- Hình ảnh -</h1>
<label>Tên hình ảnh: ${url}</label><br>
<img src="/uploads/${url}" alt=""><br><br>

<h1>- Trình phát nhạc -</h1>
<label>Tên bài hát: ${audio}</label><br>
<audio controls autoplay loop>
    <source src="/uploads/${audio}">
</audio>
</body>
</html>
