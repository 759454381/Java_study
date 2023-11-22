package com.zyb.servlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyb.pojo.Student;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private StudentService ss = new StudentServiceImpl();
//    private static final long serialVersionUID = 1L;//
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");  //设置请求编码格式
        resp.setContentType("application/json;charset=utf-8"); //设置响应编码格式


        //获取请求参数
        //因为 ID是默认自增 所有已不需要手动添加，这里直接给默认值传给实体类 id 是 int类型 所以给了默认值0
/*
        String name = req.getParameter("name");
        String pwd = req.getParameter("psw");
        int age = Integer.parseInt(req.getParameter("age"));   // 字符强转 成 int 类型 和数据库以及实体类一致
        String gender = req.getParameter("gender");
        System.out.println(name+","+pwd+","+age+","+gender);
*/


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
        String name = jsonNode.get("name").asText();
        String pwd = jsonNode.get("psw").asText();
        int age = jsonNode.get("age").asInt();
        String gender = jsonNode.get("gender").asText();
        System.out.println(name+","+pwd+","+age+","+gender);

        //处理结果
        Student student = new Student(name,pwd,age,gender);   // 通过有参构造函数 创建一个学生对象
        int i = ss.insStuService(student);      //传给 service 层 ，service 再调用 dao 层 执行 dao 层方法传给SQL 语句添加学生
        System.out.println(i);
        //响应处理结果
        PrintWriter out = resp.getWriter();
        if(i>0){    //注册成功
            out.println("{\"status\":\"success\"}");
        }else { //注册失败
            out.println("{\"status\":\"error\"}");
        }
    }
}
