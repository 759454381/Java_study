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
        //���ñ����ʽ
        req.setCharacterEncoding("utf-8");  //������������ʽ
        resp.setContentType("application/json;charset=utf-8"); //������Ӧ�����ʽ


        //��ȡ�������
        //��Ϊ ID��Ĭ������ �����Ѳ���Ҫ�ֶ���ӣ�����ֱ�Ӹ�Ĭ��ֵ����ʵ���� id �� int���� ���Ը���Ĭ��ֵ0
/*
        String name = req.getParameter("name");
        String pwd = req.getParameter("psw");
        int age = Integer.parseInt(req.getParameter("age"));   // �ַ�ǿת �� int ���� �����ݿ��Լ�ʵ����һ��
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

        // ʹ��Jackson����JSON����
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonInput.toString());
        System.out.println("jsonNode"+jsonNode.toString());

        // ��JsonNode�л�ȡ����
        String name = jsonNode.get("name").asText();
        String pwd = jsonNode.get("psw").asText();
        int age = jsonNode.get("age").asInt();
        String gender = jsonNode.get("gender").asText();
        System.out.println(name+","+pwd+","+age+","+gender);

        //������
        Student student = new Student(name,pwd,age,gender);   // ͨ���вι��캯�� ����һ��ѧ������
        int i = ss.insStuService(student);      //���� service �� ��service �ٵ��� dao �� ִ�� dao �㷽������SQL ������ѧ��
        System.out.println(i);
        //��Ӧ������
        PrintWriter out = resp.getWriter();
        if(i>0){    //ע��ɹ�
            out.println("{\"status\":\"success\"}");
        }else { //ע��ʧ��
            out.println("{\"status\":\"error\"}");
        }
    }
}
