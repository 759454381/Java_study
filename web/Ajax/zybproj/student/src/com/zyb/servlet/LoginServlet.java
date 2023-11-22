package com.zyb.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyb.pojo.Student;
import com.zyb.service.StudentService;
import com.zyb.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求格式
        req.setCharacterEncoding("utf-8");  //设置请求编码格式
        //resp.setContentType("text/html;charset=utf-8");   //设置响应 HTML编码格式
        resp.setContentType("application/json;charset=utf-8");     //设置响应 JSON编码格式

        //获取请求参数 [用户输入的，在这接收]
        String name = req.getParameter("sname");
        String psw = req.getParameter("psw");

        //处理结果
        Student student = studentService.selByNamePswService(name, psw);

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(student);

        //打印输出流输出
        PrintWriter out = resp.getWriter();
        out.println(result);
//        out.println("<b>服务器返回的内容</b>");
        //刷新关闭输出流
        out.flush();
        out.close();




    }
}
