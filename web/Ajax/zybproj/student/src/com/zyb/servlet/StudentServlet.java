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
        System.out.println("ִ�п�����");
        //������������ʽ
        req.setCharacterEncoding("utf-8");
        //������Ӧ�����ʽ
        resp.setContentType("text/html;charset=utf-8");

        //��ȡǰ��ǰ�˵���Ϣ
        String sname = req.getParameter("name");
        String psw = req.getParameter("password");
        System.out.println(sname+":"+psw);

        //���� service ��ķ��� ����������һ�� List ����
        List<Student> studentList = studentService.selAllService();
        // ѭ�����������û� ��ӡ����ǰ����̨
        for (Student student:studentList){
            System.out.println(student.toString());
        }

        // ʹ�� Jackson �������û�ת���� JSON ��ʽ������
        ObjectMapper mapper = new ObjectMapper();       //����Jackson��ʽ ת������Ķ���
        String result = mapper.writeValueAsString(studentList);     // �� ���ϵ������û���ӵ�����ķ�����

        //������Ӧ��ʽΪ JSON ��ʽ
        resp.setContentType("application/json;charset=utf-8");

        //��ӡ��������
        PrintWriter out = resp.getWriter();
        out.println(result);
//        out.println("<b>���������ص�����</b>");
        //ˢ�¹ر������
        out.flush();
        out.close();
        //resp.sendRedirect("student/index.jsp");
    }
}
