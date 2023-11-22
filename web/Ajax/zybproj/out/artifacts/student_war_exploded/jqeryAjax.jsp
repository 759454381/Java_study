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
    <title>JqueryAjax.jsp</title>
<%--    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>--%>
    <script type="text/javascript" src="js/jquery-3.7.1.js">
      /*$(function (){
        $("#btn").click(function(){
          $.ajax({
            url:"show",
            type:"post",
            data:{
              "name":"张三",
              "pwd":"12345"
            },
            success:function(data){
              $("#mydiv").html("我成功访问了"+this.data);
            },
            error:function () {
              $("#mydiv").html("访问错误");
            }
          })
          return false;
      })
    });*/
      $(function (){
        $("btn").click(function (){
          $.ajax({
            url:"demo",
            // data:{"name":"张三"},
            data:{
                "name":"张三"
            },
            type:"POST",

            success:function (data){
              // $("#div").html('请求成功'+data);
              alert("请求成功！"+data)
            },
            error:function (){
              // $("#div").html("error!")
              alert("error!")
             },
          })
          return false;
        })
      });
    </script>
    <style>
      #div{
        width: 300px;
        height: 300px;
        border: 2px solid red ;
      }
    </style>
  </head>
  <body>
    <button type="button" >查询</button>
    <hr />
    <div id="div">1234566</div>


  </body>
</html>
