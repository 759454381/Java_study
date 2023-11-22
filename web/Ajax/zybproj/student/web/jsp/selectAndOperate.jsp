<%--
  Created by IntelliJ IDEA.
  User: eboo
  Date: 2023/11/5
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>前端表格</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .delete-btn, .edit-btn {
            cursor: pointer;
            color: blue;
        }

        .editable {
            padding: 5px;
            display: inline-block;
        }

        .editing .editable {
            border: 1px solid #000;
            background-color: #ffffcc;
        }
    </style>
</head>
<body>

<table id="myTable">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
</table>

<script>
    // 使用Ajax获取数据
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '../show', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var data = JSON.parse(xhr.responseText);
            populateTable(data);
        }
    };
    xhr.send();

    function populateTable(data) {
        for (var i = 0; i < data.length; i++) {
            addRow(data[i].id, data[i].name, data[i].pwd, data[i].age, data[i].gender);
        }
    }

    function addRow(id, name, pwd, age, gender) {
        var table = document.getElementById("myTable");
        var row = table.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);

        cell1.innerHTML = id;
        cell2.innerHTML = '<span class="editable" contenteditable="false">' + name + '</span>';
        cell3.innerHTML = '<span class="editable" contenteditable="false">' + pwd + '</span>';
        cell4.innerHTML = '<span class="editable" contenteditable="false">' + age + '</span>';
        cell5.innerHTML = '<span class="editable" contenteditable="false">' + gender + '</span>';
        cell6.innerHTML = '<span class="delete-btn" onclick="deleteRow(' + id + ')">删除</span> | <span class="edit-btn" onclick="editRow(' + id + ')">编辑</span>';
    }

    function deleteRow(id) {
        // 使用Ajax将id发送到后端进行删除操作
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', 'your_backend_api_url/delete/' + id, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // 在前端删除对应行
                var row = document.querySelector('tr[data-id="' + id + '"]');
                row.parentNode.removeChild(row);
            }
        };
        xhr.send();
    }

    function editRow(id) {
        var row = document.querySelector('tr[data-id="' + id + '"]');
        row.classList.add('editing');

        var cells = row.getElementsByTagName("td");
        for (var i = 1; i <= 4; i++) {
            var span = cells[i].querySelector('.editable');
            span.setAttribute('contenteditable', 'true');
        }

        var saveBtn = row.querySelector('.edit-btn');
        saveBtn.innerHTML = '保存';
        saveBtn.onclick = function () { saveRow(id); };
    }

    function saveRow(id) {
        var row = document.querySelector('tr[data-id="' + id + '"]');
        row.classList.remove('editing');

        var cells = row.getElementsByTagName("td");
        for (var i = 1; i <= 4; i++) {
            var span = cells[i].querySelector('.editable');
            span.setAttribute('contenteditable', 'false');
        }

        var saveBtn = row.querySelector('.edit-btn');
        saveBtn.innerHTML = '编辑';
        saveBtn.onclick = function () { editRow(id); };

        // 使用Ajax将更新后的数据发送到后端进行更新操作
        var data = {
            id: id,
            name: cells[1].innerText,
            password: cells[2].innerText,
            age: cells[3].innerText,
            gender: cells[4].innerText
        };

        var xhr = new XMLHttpRequest();
        xhr.open('PUT', 'your_backend_api_url/update/' + id, true);
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // 处理更新成功的情况
            }
        };
        xhr.send(JSON.stringify(data));
    }
</script>

</body>
</html>
