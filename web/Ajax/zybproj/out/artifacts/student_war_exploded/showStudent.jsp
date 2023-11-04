<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/4
  Time: 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有学生信息</title>
<%--    <script type="text/javascript" src="js/jquery-3.7.1.js">--%>
<%--        $("sel").onclick=function (){--%>
<%--          $()--%>
<%--        }--%>
<%--    </script>--%>
    <script type="text/javascript">
        var selBtn = document.getElementsByName("sel");
        selBtn.onclike=function (){

        }
    </script>
</head>
<body>
    <div>
        <input name="sel" type="button" value="查询" onclick="clickSelAll()" />
        <table border="1" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>密码</th>
                <th>年龄</th>
                <th>性别</th>
            </tr>


        </table>
    </div>
</body>
</html>
