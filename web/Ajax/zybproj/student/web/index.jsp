<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/3
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <script>
      $(function (){
        $("a").click(function (){
          $.ajax({
            url:'show',
            data:{"name":"张三"},
            dataType:"html",
            error:function (){
              alert("请求出错");
            },
            success:function (data){
              alert('请求成功'+data);
            },
            type:"POST"
          });
          return false;
        })
      });

    </script>
  </head>
  <body>
  <div>
      <a href="show">跳转</a>
<%--    <a href="images/a.png">跳转</a>--%>
  </div>
  </body>
</html>
