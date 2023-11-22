package com.zyb.servlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyb.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parseJson")
public class ParseJsonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

/*        String name = req.getParameter("name");
        String pwd = req.getParameter("psw");
        int age = Integer.parseInt(req.getParameter("age"));   // �ַ�ǿת �� int ���� �����ݿ��Լ�ʵ����һ��
        String gender = req.getParameter("gender");

        System.out.println(name+","+pwd+","+age+","+gender);
        */

        resp.setContentType("application/json");

        // �������л�ȡJSON����
        BufferedReader reader = req.getReader();
        StringBuilder jsonInput = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonInput.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonInput.toString());

        System.out.println(jsonNode);

        String name = jsonNode.get("name").asText();
        String pwd = jsonNode.get("psw").asText();
        int age = jsonNode.get("age").asInt();
        String gender = jsonNode.get("gender").asText();
        System.out.println(name+","+pwd+","+age+","+gender);
        // ����JSON����
        Student stu = new Student();
        stu.setId(1);
        stu.setName("���");
        stu.setPwd("123456");
        stu.setAge(18);
        stu.setGender("��");

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(stu);

        System.out.println("�������������ݣ�");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
