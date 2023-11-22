package com.zyb.test;

import com.zyb.pojo.Student;
import com.zyb.service.StudentService;
import com.zyb.service.impl.StudentServiceImpl;

public class TestUpdate {
    public static void main(String[] args) {
        StudentService service = new StudentServiceImpl();
        int id= 15;
        String psw= "1111";

        int i = service.updStuService(psw, id);
        System.out.println("hello !");
    }
}
