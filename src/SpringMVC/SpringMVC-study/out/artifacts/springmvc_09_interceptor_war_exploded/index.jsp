<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 08/01/2020
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/interceptor">拦截器测试</a>
  <h1>登录页面测试</h1>
  <hr>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名： <input type="text" name="userName" placeholder="请输入用户名" required>
    <br>
    密码: <input type="text" name="password" placeholder="请输入密码" required>
    <br>
    <input type="submit" value="提交">
  </form>
  <hr>
  <h2>直接跳转成功页面测试</h2>
  <a href="${pageContext.request.contextPath}/user/success">直接跳转登入成功页面</a>
  </body>
</html>
