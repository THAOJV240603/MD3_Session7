<%--
  Created by IntelliJ IDEA.
  User: thao
  Date: 10/13/2024
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h1>Đăng ký tài khoản Google</h1>

<%--<form method="post" action="sign-up">--%>
<%--    <input type="text" name="firstName" placeholder="First Name">--%>
<%--    <input type="text" name="lastName" placeholder="Last Name"><br>--%>
<%--    <input type="text" name="email" placeholder="username"><br>--%>
<%--    <input type="password" name="password" placeholder="password">--%>
<%--    <input type="password" name="confirmPassword" placeholder="confirmPassword"><br>--%>
<%--    <button type="submit">Register</button>--%>
<%--</form>--%>

<form:form action="/sign-up" method="post" modelAttribute="formRegister">
    <form:input path="firstName" title="firstName"/>
    <form:errors path="firstName" cssStyle="color: red"/>
    <form:input path="lastName" title="lastName"/><br>
    <form:errors path="lastName" cssStyle="color: red"/>
    <form:input path="email" title="email"/><br>
    <form:errors path="email" cssStyle="color: red"/>
    <form:input path="password" type="password" title="password"/><br>
    <form:errors path="password" cssStyle="color: red"/>
    <form:input path="confirmPassword" type="password" title="confirmPassword"/>
    <form:errors path="confirmPassword" cssStyle="color: red"/>
    <button type="submit">Register</button>
</form:form>
</body>
</html>
