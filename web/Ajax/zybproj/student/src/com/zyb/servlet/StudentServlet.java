package com.zyb.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    private StudentServiceImpl studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行控制器");
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        //获取前端前端的信息
        String sname = req.getParameter("name");
        String psw = req.getParameter("password");
        System.out.println(sname+":"+psw);

        //调用 service 层的方法 ，方法返回一个 List 集合
        List<Student> studentList = studentService.selAllService();
        // 循环遍历所有用户 打印到当前控制台
        for (Student student:studentList){
            System.out.println(student.toString());
        }

        // 使用 Jackson 将所有用户转换成 JSON 格式的数组
        ObjectMapper mapper = new ObjectMapper();       //创建Jackson格式 转换处理的对象
        String result = mapper.writeValueAsString(studentList);     // 将 集合的所有用户添加到处理的方法中

        //设置响应格式为 JSON 格式
        resp.setContentType("application/json;charset=utf-8");

        //打印输出流输出
        PrintWriter out = resp.getWriter();
        out.println(result);
//        out.println("<b>服务器返回的内容</b>");
        //刷新关闭输出流
        out.flush();
        out.close();
        //resp.sendRedirect("student/index.jsp");
    }
}
