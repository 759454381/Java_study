package com.zyb.test;

import com.zyb.dao.StudentDao;
import com.zyb.dao.impl.StudentDaoImpl;
import com.zyb.pojo.Student;
import com.zyb.service.StudentService;
import com.zyb.service.impl.StudentServiceImpl;

public class TestLogin {
    public static void main(String[] args) {


/*        StudentDao sd = new StudentDaoImpl();
        String name= "ºú¾ùÆô";
        String psw= "970101";

        Student student = sd.selByNamePswDao(name, psw);
        System.out.println(student.toString());
        System.out.println("hello------------------------------ !");*/

        StudentService service = new StudentServiceImpl();
        String name= "ºú¾ùÆô";
        String psw= "970101";

        Student student = service.selByNamePswService(name, psw);
        System.out.println(student.toString());
        System.out.println("hello !");

    }
}
