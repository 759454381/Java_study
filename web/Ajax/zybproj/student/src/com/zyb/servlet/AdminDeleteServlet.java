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
        //设置编码格式
        req.setCharacterEncoding("utf-8");  //设置请求编码格式
        resp.setContentType("application/json;charset=utf-8"); //设置响应编码格式

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        System.out.println("编号:"+id+"--姓名:"+name);


        int i = studentService.delStuService(id, name);


        PrintWriter out = resp.getWriter();
        out.println(id+"已经成功删除！");
        out.flush();
        out.close();
    }
}
