package com.zyb.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zyb.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo")
public class JsonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("name="+name+":pwd="+pwd);

        Student stu = new Student();
        stu.setId(1);
        stu.setName("李白");
        stu.setPwd("123456");
        stu.setAge(18);
        stu.setGender("男");

        /*Student stu1 = new Student();
        stu1.setId(2);
        stu1.setName("刘备");
        stu1.setPwd("456123");
        stu1.setAge(20);
        stu1.setGender("男");


        List<Student> list = new ArrayList<Student>();
        list.add(stu);
        list.add(stu1);*/

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(stu);

        System.out.println("服务器返回数据！");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }
}
