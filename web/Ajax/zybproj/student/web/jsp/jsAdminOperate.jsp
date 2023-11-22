<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/19
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OK-001-v4-JS操作表格-编辑和删除操作当前行</title>
    <script>

    </script>
    <link rel="stylesheet" type="text/css" href="../css/admin-style.css">


</head>
<body>
<button type="button" id="que" onclick="see()" >查看测试</button>
<div id="myDiv"></div>

<table id="myTab">
    <tr id="head">
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
</table>

<script>

    //页面加载时---------------------------------------------------------------------------
        //ajax 查询数据
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var data = JSON.parse(xhr.responseText);
            populateTable(data);
        }
    };
    xhr.open('GET', '../show', true);
    xhr.send();

    //
    function populateTable(data) {
        for (let i = 0; i < data.length; i++) {
            addRow(data[i].id, data[i].name, data[i].pwd, data[i].age, data[i].gender);
        }
    }

   function addRow(id, name, pwd, age, gender){
        var myTab = document.getElementById("myTab");   //获取表格
        var rowNum =myTab.rows[0].cells.length;     //获取列数（每行长度）：即每一个指定行--单元格个数

/*
        //将数据和标签 结合，变成字符串
        var s_id= '<span class="editable" contenteditable="false">' + id + '</span>';
        var s_name= '<span class="editable" contenteditable="false">' + name + '</span>';
        var s_password= '<span class="editable" contenteditable="false">' + pwd  + '</span>';
        var s_age= '<span class="editable" contenteditable="false">' + age + '</span>';
        var s_gender= '<span class="editable" contenteditable="false">' + gender + '</span>';
        var operate = '<button class="edit-btn" onclick="editRow(this)">编辑</button> | <button  class="delete-btn" onclick="deleteRow(this)">删除</button>';

*/

       var s_id= '<span class="editable" contenteditable="false" name="id">' + id + '</span>';
       var s_name= '<span class="editable" contenteditable="false" name="name">' + name + '</span>';
       var s_password= '<span class="editable" contenteditable="false" name="pwd">' + pwd  + '</span>';
       var s_age= '<span class="editable" contenteditable="false" name="age">' + age + '</span>';
       var s_gender= '<span class="editable" contenteditable="false" name="gender">' + gender + '</span>';
       var operate = '<button class="edit-btn" onclick="editRow(this)">编辑</button> | <button  class="delete-btn" onclick="deleteRow(this)">删除</button>';

        //var stu=["编号" + j,"姓名" + j,"密码123qq" + j,20 + j,j % 2 == 0 ? "男"+j : "女"+j,operate]; //定义一个数组，循环生成数组  这就是相当于后端数据
        //var stu=[id, name, password, age, gender,operate]; //定义一个数组，循环生成数组  这就是相当于后端数据
        var stu=[s_id, s_name, s_password, s_age, s_gender,operate]; //将字符窜添加到数字

        //内循环打印单元格（列数）
        var row = myTab.insertRow(-1);  //设置 表格添加行 设置值为 -1 在表格最下面添加一行
        for(var i = 0; i < rowNum; i++){        //生成一个人数据 横向的单元格
            var k= "cell"+(i+1);    //设置可变拼接值赋给--变量 x
            k =row.insertCell(i);    //每一行循环添加单元格
            k.innerHTML = stu[i];   //为每一个单元格添加数组内的值
        }

    }


    // 查看测试-----------------------------------------------------------------------------------------
    function see(){
        var myTab = document.getElementById("myTab");   //获取表格
        var div1=document.getElementById("myDiv");      //获取div

        //注意innerHTML 每次输出都会清空原来的相同的参数的值

        var rowNum =myTab.rows[0].cells.length;     //获取列数（每行长度）：即每一个指定行--单元格个数
        div1.innerHTML="每行 "+ rowNum +"个单元格 <br />";      //输出 长度

        //获取行数
        var cellNum =myTab.rows.length;
        div1.innerHTML=cellNum;

        // 查询 多少条数据
        var cellNum =myTab.rows.length;
        div1.innerHTML+="表格有tr："+(cellNum-1) + " 行数据";

    }


    //删除按钮-----------------------------------------------------------------------------------------
    function deleteRow(btn) {   // 这里btn 是一个实参 随意的实参  应为设定的时 this

        var row = btn.parentNode.parentNode;
        var cells = row.getElementsByTagName("td");
        var spans = row.querySelectorAll(".editable");
        var cellValues =[];

        for(var i=0;i<spans.length;i++){
            var spanVal= spans[i].innerText;
            cellValues.push(spanVal);
        }

        var sid= cellValues[0];
        var name=cellValues[1];

        // alert("你确定要删除吗?"+spans[0].innerText);
        alert("你确定要删除吗?"+sid);
        row.parentNode.removeChild(row);

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // 在前端删除对应行
                // var data = JSON.parse(xhr.responseText);
                var data = xhr.responseText;        //接收响应信息 这里接收一个后端的输出语句

                document.getElementById("myDiv").innerHTML=data;
                console.log("数据删除成功! "+data);
            }
        };
        xhr.open('DELETE', '../adminDel?id='+sid+"&name="+name, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        // xhr.send(JSON.stringify({ name: name }));
        xhr.send();

        /*
        var row = btn.parentNode.parentNode;
        var cells = row.getElementsByTagName("td");
        var spans = row.querySelectorAll(".editable");
        var cellValues =[];

        for(var i=0;i<spans.length;i++){
            var sp = spans[i].innerText;
            cellValues.push(sp);
        }
        alert("你确定要删除吗? 编号为:"+spans[0].innerText);
        row.parentNode.removeChild(row);
        */
    }

    //编辑按钮 -----------------------------------------------------------------------------------------
    function editRow(btn) {
        var row = btn.parentNode.parentNode;    // 当前点击对象的父节点的父节点 ,这个按钮的父节点是<td>然后是 <tr>

        var spans = row.querySelectorAll(".editable");
        spans[0].setAttribute("id","idVal");
        row.classList.add('ing');       // .ing .editable{} 解释：参开CSS选择器【.class1 .class2	.name1 .name2	选择作为类名 name1 元素后代的所有类名 name2 元素。】每行的 返回类名的 添加方法添加 一个或多个令牌添  此类名的列表中

        var cellValues =[];

        for(var i=0;i<spans.length;i++){
            if(i==0){
                spans[i].setAttribute('contenteditable', 'false');
                spans[0].setAttribute("id","idVal");
            }else{
                spans[i].setAttribute('contenteditable', 'true');
            }
            var sp = spans[i].innerText;
            cellValues.push(sp);
        }

        var sid = cellValues[0];
        console.log(spans[0].innerText);

        btn.innerHTML = '保存'; // 修改按钮文字为“保存”
        btn.onclick = function () { saveRow(this); }; // 更改按钮功能为保存编辑
    }

    //点击保存事件
    function saveRow(btn){  //调用函数（方法） saveRow(this)
        var row = btn.parentNode.parentNode;    // 当前点击对象的父节点的父节点 ,这个按钮的父节点是<td>然后是 <tr>
        row.classList.remove('ing');       // 每行的 返回类名的 添加方法添加 一个或多个令牌添  此类名的列表中
        var spans = row.querySelectorAll(".editable");
        spans[0].removeAttribute("id");

        var cellValues =[];

        for(var i=0;i<spans.length;i++){
            var sp = spans[i].innerText;
            cellValues.push(sp);
            spans[i].setAttribute('contenteditable', 'false');
        }

        btn.innerHTML="编辑";
        btn.onclick=function (){
            editRow(this);
        }

        var x="";
        var arrData =[];
        for(var j=0;j<spans.length;j++){
            var attrVal = spans[j].getAttribute("name");
            arrData.push('"'+attrVal+'":"'+cellValues[j]+'"');
            if(j!=spans.length-1){
                x+=arrData[j]+",";
            }else{
                x+=arrData[j];
            }


        }

        var jData="{"+x+"}";

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // 在前端删除对应行
                // var data = JSON.parse(xhr.responseText);
                var data = xhr.responseText;        //接收响应信息 这里接收一个后端的输出语句

                document.getElementById("myDiv").innerHTML=data;
                console.log("数据修改成功! "+data);
            }
        };
        xhr.open('post', '../adminUpd', true);
        xhr.setRequestHeader("Content-Type", "application/json");
        // xhr.send(JSON.stringify({ name: name }));
        xhr.send(jData);

    }

</script>
</body>
</html>
