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
    <title>index.jsp</title>
<%--    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>--%>
    <script>
     /* $(function (){
        $("a").click(function (){
          /!*$.ajax({
            url:'show',
            // data:{"name":"张三"},
            data:{"name":"张三"},
            dataType:"html",
            error:function (){
              alert("请求出错");
            },
            success:function (data){
              alert('请求成功'+data);
            },
            type:"POST"*!/

          $.port("demo",{"name":"张三"},function (data){
            alert(data.id+" "+data.username +" "+data.password);
          });
          return false;
        })
      });*/
    </script>
  </head>
  <body>
  <div>
      <hr>
      <h2>查询所有--并有操作功能---更改/删除</h2>
<%--    这两个用的同一个StudentServlet.java--%>
    <a href="jqueryAjax.jsp">查询全部--jqueryAjax </a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="jsp/jsAjax.jsp"> 查询全部--jsAjax</a>&nbsp;&nbsp;&nbsp;&nbsp;

    <a href="jsp/loginQuery.jsp"> 登陆--查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="jsp/registerQuery.jsp"> 注册--查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="jsp/deleteQuery.jsp"> 删除--查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="jsp/updateQuery.jsp"> 修改信息--查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <br />
      <br />
      <br />
      <br />

    <a href="jsp/selectAndOperate.jsp"> 先查询全部--然后遍历表格-每一行都有 更改和删除的按钮</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="jsp/jsAdminOperate.jsp"> 管理员操作</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%--      <a href="show">跳转</a>--%>
<%--    <a href="images/a.png">跳转</a>--%>
  </div>
  </body>
</html>
