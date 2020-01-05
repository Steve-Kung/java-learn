<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/01/2020
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍页面</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<br>
<div class="page-header" align="center">
    <h1>修改书籍列表</h1>
</div>
<hr>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
                <input type="hidden" name="bookId" value="${updateBook.bookId}">
                <div class="form-group">
                    <p class="h4 text-primary">书籍名字</p>
                    <input type="text" class="form-control" name="bookName" value="${updateBook.bookName}">
                </div>
                <div class="form-group">
                    <p class="h4 text-primary">书籍数量</p>
                    <input type="text" class="form-control" name="bookCounts" value="${updateBook.bookCounts}">
                </div>
                <div class="form-group">
                    <p class="h4 text-primary">书籍详情</p>
                    <input type="text" class="form-control" name="bookDetails" value="${updateBook.bookDetails}">
                </div>
                <button type="submit" class="btn btn-success">修改</button>
            </form>
        </div>
        <div class="col-4"></div>
    </div>
</div>

</body>
</html>
