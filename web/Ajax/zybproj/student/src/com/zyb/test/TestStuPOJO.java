package com.zyb.test;

import com.zyb.pojo.Student;

public class TestStuPOJO {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("ÕÅÈý");
        s1.setPwd("zs123");
        s1.setAge(23);
        s1.setGender("ÄÐ");
        System.out.println(s1.hashCode());
    }
}
