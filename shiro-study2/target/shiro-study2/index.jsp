<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath}/user/register">注册</a>
欢迎您：
<shiro:user>
    <shiro:principal/>
    <a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
</shiro:user>

<shiro:guest>
    <a href="${pageContext.request.contextPath}/user/login">请登录</a>
</shiro:guest>


<hr>

<shiro:hasRole name="bangzhang">

    <a href="#"> 财务发工资</a>
</shiro:hasRole>

<shiro:lacksRole name="bangzhang">
    <a href="#"> 等待财务发工资</a>
</shiro:lacksRole>

<shiro:hasAnyRoles name="bangzhang,student">
    <a href="#">回家</a>
</shiro:hasAnyRoles>

<hr>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>operation</td>
    </tr>
    <tr>
        <td>001</td>
        <td>
            <shiro:principal></shiro:principal>
        </td>
        <td>
            <shiro:hasAnyRoles name="bangzhang,student">
                详情
            </shiro:hasAnyRoles>
            <shiro:hasRole name="student">
                删除
            </shiro:hasRole>
            <shiro:lacksRole name="bangzhang">
                点击升级
            </shiro:lacksRole>

        </td>
    </tr>
</table>
<hr>
<shiro:hasPermission name="student:yq">
    班长要钱
</shiro:hasPermission>
<shiro:lacksPermission name="student:study">
    学生学习
</shiro:lacksPermission>

<shiro:hasPermission name="student:study">
    学生学习
</shiro:hasPermission>
</body>

</html>


