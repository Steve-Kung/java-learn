<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/01/2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--上传文件表单--%>
  <h1>上传文件</h1>
  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
  </form>
  <form action="${pageContext.request.contextPath}/upload2" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传2">
  </form>
  <h1>下载文件</h1>
  <a href="./statics/ABCD.png">点击链接1</a>
  <a href="${pageContext.request.contextPath}/download">点击链接2</a>
  </body>
</html>
