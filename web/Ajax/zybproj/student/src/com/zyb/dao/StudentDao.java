package com.zyb.dao;

import com.zyb.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> selAllDao();

    /**
     * 通过姓名和密码查询所学生信息
     * @param name
     * @param psw
     * @return Student
     */
    Student selByNamePswDao(String name,String psw);

    /**
     * 注册一个学生
     *
     * @param student
     * @return
     */
    int insStuDao(Student student);

    /**
     * 删除人员
     * @param ID
     * @param name
     * @return
     */
    int delStuDao(int ID,String name);

    int updStuDao(String pwd,int id);

}
