<%--
  Created by IntelliJ IDEA.
  User: 17284
  Date: 2020/3/19
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>登录</h3>

<form action="${pageContext.request.contextPath}/user/savelogin" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="text" name="password"><br>
    <input type="submit" value="登录">


</form>
</body>
</html>
