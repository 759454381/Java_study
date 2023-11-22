package com.zyb.servlet;

import com.zyb.service.StudentService;
import com.zyb.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adminDel")
public class AdminDeleteServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //���ñ����ʽ
        req.setCharacterEncoding("utf-8");  //������������ʽ
        resp.setContentType("application/json;charset=utf-8"); //������Ӧ�����ʽ

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        System.out.println("���:"+id+"--����:"+name);


        int i = studentService.delStuService(id, name);


        PrintWriter out = resp.getWriter();
        out.println(id+"�Ѿ��ɹ�ɾ����");
        out.flush();
        out.close();
    }
}
