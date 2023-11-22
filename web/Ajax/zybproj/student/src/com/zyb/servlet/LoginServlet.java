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
        //���������ʽ
        req.setCharacterEncoding("utf-8");  //������������ʽ
        //resp.setContentType("text/html;charset=utf-8");   //������Ӧ HTML�����ʽ
        resp.setContentType("application/json;charset=utf-8");     //������Ӧ JSON�����ʽ

        //��ȡ������� [�û�����ģ��������]
        String name = req.getParameter("sname");
        String psw = req.getParameter("psw");

        //������
        Student student = studentService.selByNamePswService(name, psw);

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(student);

        //��ӡ��������
        PrintWriter out = resp.getWriter();
        out.println(result);
//        out.println("<b>���������ص�����</b>");
        //ˢ�¹ر������
        out.flush();
        out.close();




    }
}
