package com.zyb.test;

import com.zyb.pojo.Student;
import com.zyb.service.StudentService;
import com.zyb.service.impl.StudentServiceImpl;

public class TestRegister {

    public static void main(String[] args) {

        Student student = new Student("����","123321",22,"��");

        StudentService studentService =new StudentServiceImpl();
        int i = studentService.insStuService(student);
        System.out.println(i);
    }
}