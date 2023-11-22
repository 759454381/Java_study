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
    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>
    <style>
        #mydiv{
            width: 500px;
            height: 500px;
            border: 1px solid blue;
        }
    </style>
</head>
<h3>用 JQuery ajax发送请求查询全部</h3>
<hr>
    <button id="btn">查询</button>
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

    <script>
        $(function (){  //加载页面 相当于|  $(document).ready(function(){}
            $("#head").hide();      // 加载页面隐藏 这个标签
            $("#btn").click(function () {       //当这个按钮被点击了，执行函数
                $("#head").show();      //   点击按钮执行 显示show 函数，显示此元素
                $.ajax({            // 使用 Ajax 执行异步操作，相当于开了另一条线程
                    type: "GET",    // 通过 get 发送请求 ；请求方式，一般为get、post
                    url: "show",    //  表示访问那个后端服务器的控制器——后台接口地址
                    data:{          // 此处是用于和后端接收和发送数据的地方----------------接收后端resp发来的数据 和给后端req接收的数据
                        "name":"张三" // 这是发给后端的数据 这里是查询所以 传不传无所谓 试验一下而已
                    },
                    contentType:'application/json;charset=utf-8',   //请求端数据的编码设置--如果要发送json字符串，此属性不能少；否则，会出现后台会报异常，
                    success: function (data) {      // 请求成功 执行的函数 这个data 就是上面的 data，data中包含了 后端发来的数据
                        var result="";
                        for(var i=0; i<data.length; i++){
                            result+="<tr>";
                            result+="<td>"+data[i].id+"</td>"
                            result+="<td>"+data[i].name+"</td>"
                            result+="<td>"+data[i].pwd +"</td>"
                            result+="<td>"+data[i].age +"</td>"
                            result+="<td>"+data[i].gender +"</td>"
                            result+="</tr>";
                        }
                        //相当innerHTML先清空后添加
                        $("#mytbody").html(result);

                        var result1="";
                        for(var j=0; j<data.length; j++){
                            result1+=data[j].id+" "
                            result1+=data[j].name+" "
                            result1+=data[j].pwd+" "
                            result1+=data[j].age+" "
                            result1+=data[j].gender+"<br/>"
                        }
                        $("#mydiv").html(result1);
                        // $("#mydiv").html("成功访问:<br />ID:"+data.id+" 姓名:"+data.name)+"密码:" +
                        // data.pwd+"密码:" + data.age+"密码:" + data.gender;);

                    },
                    error: function () {            // 请求失败 执行的操作 没有服务端的数据或者没访问到资源（路径问题和前端语法问题）
                        $("#mydiv").html("error!");
                    }
                });
            });
        });
    </script>
</body>
</html>
