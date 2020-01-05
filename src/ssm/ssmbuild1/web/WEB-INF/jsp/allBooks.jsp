<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 04/01/2020
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有书籍</title>
    <%--<script src="../tools/jquery.min.js"></script>--%>
    <%--<link href="../tools/bootstrap.min.css" rel="stylesheet">--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%--<script src="../tools/bootstrap.min.js"></script>--%>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<br>
<div class="page-header" align="center">
    <h1>全部书籍列表</h1>
</div>
<hr>
<br>
<div class="container">
    <div class="row">
        <div class="col-4">
            <a class="btn btn-success" href="${pageContext.request.contextPath}/book/toAddBookPage">添加书籍</a>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/book/selectBooks">查看全部书籍</a>
        </div>
        <div class="col-4"></div>
        <div class="col-4">
            <form action="${pageContext.request.contextPath}/book/selectBookByName" method="post" class="input-group">
                <input type="text" name="bookName" class="form-control" placeholder="请输入书籍名称" required>
                <button type="submit" class="btn btn-warning">搜索</button>
            </form>
        </div>
    </div>
    <div align="right">
        <span class="text-danger pull-right">${msg}</span>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col">
            <table class="table table-striped table-hover">
                <thead>
                <th class="text-info">书籍ID</th>
                <th class="text-info">书籍名字</th>
                <th class="text-info">书籍数量</th>
                <th class="text-info">书籍详情</th>
                <th class="text-info">书籍操作</th>
                </thead>
                <tbody>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.bookDetails}</td>
                        <td>
                            <a class="btn btn-outline-primary btn-sm" href="${pageContext.request.contextPath}/book/toUpdateBookPage/${book.bookId}">修改</a>
                            <a class="btn btn-outline-danger btn-sm" href="${pageContext.request.contextPath}/book/deleteBook/${book.bookId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
