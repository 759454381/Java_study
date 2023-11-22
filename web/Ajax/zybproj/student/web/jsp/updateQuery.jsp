<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/5
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jqueryAjax.jsp</title>
    <script type="text/javascript" src="../js/jquery-3.7.1.js"></script>
    <script>
        $(function (){  //加载页面 相当于|  $(document).ready(function(){}
            $("#btn").click(function () {       //当这个按钮被点击了，执行函数
                var id =$("#sid").val();
                var pwd = $("#password").val();
                var formData = {
                    "sid":id,
                    "psw":pwd
                };
                $("#myDiv1").html(id+"--"+pwd);
                $.ajax({            // 使用 Ajax 执行异步操作，相当于开了另一条线程
                    type: "post",    // 通过 get 发送请求 ；请求方式，一般为get、post
                    url: "../upd",    //  表示访问那个后端服务器的控制器——后台接口地址
                      // 接收的数据的数据是 json格式的
                    data:JSON.stringify(formData),
                    contentType:'application/json;charset=utf-8',   //请求端数据的编码设置--如果要发送json字符串，此属性不能少；否则，会出现后台会报异常，
                    success: function (data) {      // 请求成功 执行的函数 这个data 就是上面的 data，data中包含了 后端发来的数据
                        $("#myDiv").html("success!");
                    },
                    error: function () {            // 请求失败 执行的操作 没有服务端的数据或者没访问到资源（路径问题和前端语法问题）
                        $("#myDiv").html("error!");
                    },
                    dataType: 'json'
                });
            });
        });
    </script>
    <style>
        #mydiv{
            width: 500px;
            height: 500px;
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<h3>根据id 修改密码</h3>
    <form>
        <label for="sid">id:</label>
        <input type="text" id="sid" name="sid" ><br>

        <label for="password">密码:</label>
        <input type="password" id="password" name="psw" required><br>

        <button id="btn" type="button">修改信息</button>
    </form>
<div id="myDiv"></div>
<div id="myDiv1"></div>
</body>
</html>
