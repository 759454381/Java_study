package com.zyb.servlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/adminUpd")
public class AdminUpdateServlet extends HttpServlet {
    private StudentService ss = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //���ñ����ʽ
        req.setCharacterEncoding("utf-8");  //������������ʽ
        resp.setContentType("application/json;charset=utf-8"); //������Ӧ�����ʽ

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
//        int id = jsonNode.get("sid").asInt();
//        String pwd = jsonNode.get("psw").asText();
//        System.out.println("id:"+id+"--pwd:"+pwd);

        int id = jsonNode.get("id").asInt();
        String name = jsonNode.get("name").asText();
        String pwd = jsonNode.get("pwd").asText();
        int age = jsonNode.get("age").asInt();
        String gender = jsonNode.get("gender").asText();
        System.out.println("id:"+id+" name:"+name+" pwd:"+pwd+" age:"+age+" gender:"+gender);
//        System.out.println("�����"+id + name + pwd + age + gender);

        //������
        int i = ss.updStuService(pwd,id)  ;    //���� service �� ��service �ٵ��� dao �� ִ�� dao �㷽������SQL ������ѧ��
        System.out.println(i);

        //��Ӧ������
        PrintWriter out = resp.getWriter();
        out.println(id+"�Ѿ��ɹ��޸ģ�");
        out.flush();
        out.close();
    }
}
