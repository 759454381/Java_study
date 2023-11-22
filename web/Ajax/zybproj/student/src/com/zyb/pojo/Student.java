package com.zyb.pojo;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String pwd;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(int id, String name, String pwd, int age, String gender) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.gender = gender;
    }
    public Student( String name, String pwd, int age, String gender) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.gender = gender;
    }

    public Student( int id,String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && name.equals(student.name) && pwd.equals(student.pwd) && gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pwd, age, gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
