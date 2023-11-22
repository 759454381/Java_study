<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/3
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
<%--    <script type="text/javascript" src="js/jquery-3.7.1.js"></script>--%>
    <script>
      function loadDoc() {
        var xmlhttp;
        if(window.XMLHttpRequest){//火狐
          xmlhttp=new XMLHttpRequest();
        }else if(window.ActiveXObject){//ie
          // xhttp=new ActiveXObject("Microsoft.XMLHTTP");
          xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        /*xmlhttp.onreadystatechange=function (){
          var result = xmlhttp.responseText;
          var mydiv = document.getElementById("mydiv");
          mydiv.innerHTML=result;
        }*/

        xmlhttp.onreadystatechange=function()
        {
          if (xmlhttp.readyState==4 && xmlhttp.status==200)
          {
            // var myObj =  JSON.parse(this.responseText);
            var data =  JSON.parse(this.responseText);
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
            // 表格输出 result 循环拼接结果
            document.getElementById("mytbody").innerHTML=result;
            // document.getElementById("mytbody").innerHTML=xmlhttp.responseText;  //innerHTML 加载会把里面的内容清空 所以table 表格不能放在 div中不然

            document.getElementById("myDiv").innerHTML=xmlhttp.responseText;    // div 输出 键值对 ，这里用的是 JSON格式的 ，转换工具有 Jackson， Gson 等等可以自行查找
          }
        }
        //-------------------get 请求发送--------------------------
          //这里设置的这些编码格式都不好使，保存文本文件 ajaxInfo.txt 的时候用utf-8保存 不要用ANSI 保存
        // xmlhttp.open("get", "../show",true);
        xmlhttp.open("get", "../show",true);
        // xmlhttp.open("get", "../show?name=关羽&password=pwd12346",true);  // "../show?name=关羽&password=pwd12346" 这个使用来向后端控制器servlet 发送的数据的
        xmlhttp.send();


          //-------------------post 请求发送--------------------------
/*        xmlhttp.open("post", "../demo",true);
        xmlhttp.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");   //用来发送请求头信息的编码格式
          // 是键值对形式的方发送到服务端 servlet----如果不设置这个 那么以 post 方式发送的 xmlhttp.send("name=张三&pwd=234");
          // 在servlet 中无法以键值对的方式范文就无法取到值 ，显示的结果也是name=null:pwd=null
        xmlhttp.send("name=张三&pwd=234");
*/



          // xmlhttp.setRequestHeader("If-Modified-Since","0");
          //xmlhttp.setRequestHeader('Content-Type','html/text;charset=gb2312');
          //   xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
          // xmlhttp.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");


      }
    </script>

    <style>
      #myDiv{
        width: 600px;
        height: auto;
        border: 1px solid black ;
      }
    </style>
  </head>
  <body>

    <h1>XMLHttpRequest 对象</h1>
    <h3>用远程JS ajax 查询全部</h3>
    <button type="button" onclick="loadDoc()">查询全部</button>
    <div id="myDiv">

    </div>
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
