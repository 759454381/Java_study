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
        $(function (){
            $("#delBtn").click(function (){
                var sid=$("#sID").val();
                var sname =$("#sName").val();
                var formData={
                    "id":sid,
                    "name":sname
                }
                $("#myDiv").html("id:"+sid+"name:"+sname);
               $.ajax({
                   url:"../del",
                   type:"post",
                   contentType: "application/json",
                   data:JSON.stringify(formData),
                   success:function (data){
                       $("#myDiv").html("删除成功");
                   },
                   error:function (){
                       $("#myDiv").html("删除失败");
                   },
               })
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
<h3>根据id 姓名删除学生</h3>
<form>
    <span>编 号:</span><input id="sID"  type="number" name="sID"  />
    <span>姓 名:</span><input id="sName"  type="text" name="sName"  />
    <button id="delBtn" type="button" name="delBtn">删除</button>
</form>

    <div id="myDiv"></div>
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
</body>
</html>
