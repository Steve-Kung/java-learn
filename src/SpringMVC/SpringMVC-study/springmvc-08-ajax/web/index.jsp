<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 07/01/2020
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.min.js"></script>--%>
    <script>
      function onBlur() {
          $.post({
              url : "${pageContext.request.contextPath}/onBlur",
              data: {'name' : $("#txtName").val()}, //传递给后端的数据 name
              success: function (data){
                  alert(data);
              }
          });
      }
      function onClick() {
          $.post({
              url: "${pageContext.request.contextPath}/ajax2",
              success: function (data) {
                  console.log(data);
                  var html = "";
                  for(var i = 0; i<data.length; i++){
                      html+="<tr>" + "<td>" + data[i].name + "</td>"
                                    + "<td>" + data[i].age + "</td>"
                                    + "<td>" + data[i].sex + "</td>"
                      + "</tr>";
                  }
                  $("#content").html(html);
              }
          });
      }
      function onBlurUserName() {
          $.post({
              url: "${pageContext.request.contextPath}/ajax3",
              data: {'username':$("#username").val()},
              success: function (data) {
                  if(data.toString()=="OK"){
                      $("#userNameInfo").css("color","green");
                  } else {
                      $("#userNameInfo").css("color","red");
                  }
                  $("#userNameInfo").html(data);
              }
          });
      }
      function onBlurPassword(){
          $.post({
              url: "${pageContext.request.contextPath}/ajax3",
              data: {'password':$("#password").val()},
              success: function (data) {
                  if(data.toString()=="OK"){
                      $("#passwordInfo").css("color", "green");
                  } else {
                      $("#passwordInfo").css("color", "red");
                  }
                  $("#passwordInfo").html(data);
              }
          });
      }
    </script>

  </head>
  <body>
    <%----%>
    <div>
     姓名 <input type="text" placeholder="请输入姓名" id="txtName" onblur="onBlur()">
    </div>
    <%--数据回显--%>
    <div>
      <input type="button" id="btn" value="获取数据" onclick="onClick()">
      <table width="80%" align="center">
        <tr>
          <td>姓名</td>
          <td>年龄</td>
          <td>性别</td>
        </tr>
        <tbody id="content">
        </tbody>
      </table>
    </div>
    <%--数据输入实时显示--%>
  <div>
    用户名： <input type="text" id="username" onblur="onBlurUserName()" placeholder="请输入姓名...">
    <span id="userNameInfo"></span>
  </div>
  <div>
    密码： <input type="text" id="password" onblur="onBlurPassword()" placeholder="请输入密码...">
    <span id="passwordInfo"></span>
  </div>
  </body>
</html>