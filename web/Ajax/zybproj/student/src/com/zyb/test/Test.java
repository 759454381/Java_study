package com.zyb.test;

import com.zyb.dao.StudentDao;
import com.zyb.dao.impl.StudentDaoImpl;
import com.zyb.pojo.Student;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        StudentDao sd = new StudentDaoImpl();
        List<Student> students = sd.selAllDao();
        for (Student student:students){
            System.out.println(student.toString());
        }

    }
}
