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
    <title>Register.jsp</title>
    <script type="text/javascript" src="../js/jquery-3.7.1.js"></script>
    <script>
        $(function (){
            $("#sub").click(function (){
                var name=$("#name").val();
                var psw=$("#password").val();
                var age =$("#age").val();
                var gender=$("input[name='gender']:checked").val();

                  var formData = {
                      "name": name,
                      "psw": psw,
                      "age": age,
                      "gender": gender
                  }
                $("#myDiv").html(name+","+psw+","+age+","+gender);
                //alert(name+","+psw+","+age+","+gender);
                $.ajax({
                    type: "post",
                    contentType: "application/json",
                    // url: "../register",
                    url: "../register",
                    data:JSON.stringify(formData),
                    /*data: {
                        "name": name,
                        "psw":psw,
                        "age": age,
                        "gender": gender
                    },*/
                    dataType: 'json',
                    success: function (data) {
                        $("#result").html("<p>注册成功！</p>");
                    },
                    error: function () {
                        $("#result").html("<p>注册失败，请重试。</p>");
                    }

                })

            })
        });
    </script>
    <style>
        #result{
            width: 500px;
            height: 200px;
            border: 1px solid black;
        }
        #myDiv{
            width: 500px;
            height: 200px;
            border: 1px solid black;
        }

    </style>
</head>
<body>

<h2>用户注册</h2>

<form id="registrationForm">
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="password">密码:</label>
    <input type="password" id="password" name="psw" required><br>

    <label for="age">年龄:</label>
    <input type="text" id="age" name="age" required><br>

    <label>性别:</label>

    <input type="radio" id="male" name="gender" value="男">
    <label for="male">男性</label>

    <input type="radio" id="female" name="gender" value="女">
    <label for="female">女性</label><br>

    <button id="sub" type="button" name="sub">提交</button>
</form>
<h3>显示提交信息-此信息记录注册时填写的信息并不是后台数据</h3>
<div id="myDiv"></div>
<h3>显示注册状态</h3>
<div id="result"></div>


</body>
</html>
