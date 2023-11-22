package com.zyb.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyb.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/testDel")
public class TestAdminServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        System.out.println("id=" + id + ":name=" + name);

        Student stu = new Student();
        stu.setId(1);
        stu.setName("���");
        stu.setPwd("123456");
        stu.setAge(18);
        stu.setGender("��");

        /*Student stu1 = new Student();
        stu1.setId(2);
        stu1.setName("����");
        stu1.setPwd("456123");
        stu1.setAge(20);
        stu1.setGender("��");


        List<Student> list = new ArrayList<Student>();
        list.add(stu);
        list.add(stu1);*/

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(stu);

        System.out.println("�������������ݣ�");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("ok!");
        out.flush();
        out.close();
    }
}
