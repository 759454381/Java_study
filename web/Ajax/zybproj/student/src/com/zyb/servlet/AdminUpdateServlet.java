package com.zyb.servlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyb.service.StudentService;
import com.zyb.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adminUpd")
public class AdminUpdateServlet extends HttpServlet {
    private StudentService ss = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");  //设置请求编码格式
        resp.setContentType("application/json;charset=utf-8"); //设置响应编码格式

        StringBuilder jsonInput = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonInput.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用Jackson解析JSON数据
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonInput.toString());

        System.out.println("jsonNode"+jsonNode.toString());

        // 从JsonNode中获取数据
//        int id = jsonNode.get("sid").asInt();
//        String pwd = jsonNode.get("psw").asText();
//        System.out.println("id:"+id+"--pwd:"+pwd);

        int id = jsonNode.get("id").asInt();
        String name = jsonNode.get("name").asText();
        String pwd = jsonNode.get("pwd").asText();
        int age = jsonNode.get("age").asInt();
        String gender = jsonNode.get("gender").asText();
        System.out.println("id:"+id+" name:"+name+" pwd:"+pwd+" age:"+age+" gender:"+gender);
//        System.out.println("输出："+id + name + pwd + age + gender);

        //处理结果
        int i = ss.updStuService(pwd,id)  ;    //传给 service 层 ，service 再调用 dao 层 执行 dao 层方法传给SQL 语句添加学生
        System.out.println(i);

        //响应处理结果
        PrintWriter out = resp.getWriter();
        out.println(id+"已经成功修改！");
        out.flush();
        out.close();
    }
}
