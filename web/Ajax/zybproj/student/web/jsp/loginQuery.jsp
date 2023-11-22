<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/6
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相当于登陆</title>
    <script type="text/javascript" src="../js/jquery-3.7.1.js"></script>
    <script>
        $(function(){
            $("#enter").click(function (){
                var acc = $("#acc").val();
                var pwd = $("#pwd").val();
                $.ajax({
                    url:"../login",
                    type:"get",
                    data:{
                        "sname":acc,
                        "psw":pwd
                        /*"sname":"胡均启",
                        "psw":"970101"*/

                    },
                    dataType: 'json',
                    success:function (data) {
                        var result1=data.id+" "+data.name+" "+data.pwd+" "+data.age+" "+data.gender;
                        var result="";
                            result+="<tr>";
                            result+="<td>"+data.id+"</td>"
                            result+="<td>"+data.name+"</td>"
                            result+="<td>"+data.pwd +"</td>"
                            result+="<td>"+data.age +"</td>"
                            result+="<td>"+data.gender +"</td>"
                            result+="</tr>";

                        /*for(var j=0; j<data.length; j++){
                            result1+=data[j].id+" "
                            result1+=data[j].name+" "
                            result1+=data[j].pwd+" "
                            result1+=data[j].age+" "
                            result1+=data[j].gender+"<br/>"
                        }*/
                        $("#mytbody").html(result);
                        $("#mydiv").html(result1);
                    },
                    error:function (){
                        $("#mydiv").html("error!");
                    }
                });
            });
        });


    </script>
    <style>
        #mydiv{
            width: 500px;
            height: 150px;
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<h3>登陆--相当于按照账号密码查询</h3>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input id="acc"  type="text" name="sname" placeholder="用户名" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input id="pwd" type="password" name="psw" placeholder="输入密码" /></td>
            </tr>
            <tr>
                <td><button id="enter" type="button" >登录</button></td>
                <td><input type="button" value="重置"/></td>
            </tr>

        </table>
        <div id="mydiv"></div>

        <table border="1">
            <tr id="head">
                <td>编号</td>
                <td>姓名</td>
                <td>密码</td>
                <td>年龄</td>
                <td>性别</td>
            </tr>
            <tbody id="mytbody"></tbody>
        </table>
    </form>
</body>
</html>
