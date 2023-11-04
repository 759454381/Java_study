package com.zyb.servlet;

import com.zyb.dao.StudentDao;
import com.zyb.dao.impl.StudentDaoImpl;
import com.zyb.pojo.Student;
import com.zyb.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/show")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        //req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Student> students = studentService.selAllService();
        for (Student student:students){
            System.out.println(student.toString());
        }
        System.out.println("执行控制器");
        PrintWriter out = resp.getWriter();
        out.println("<b>服务器返回的内容</b>");
        out.flush();
        out.close();
        resp.sendRedirect("student/index.jsp");
    }
}
