package com.zyb.service;

import com.zyb.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> selAllService();

    /**
     * 登陆查询
     * @param name
     * @param psw
     * @return
     */
    Student selByNamePswService(String name,String psw);

    /**
     * 注册用户 新增功能
     * @param student
     * @return
     */
    int insStuService(Student student);

    /**
     *删除学生 根据编号和姓名
     * @param ID
     * @param name
     * @return
     */
    int delStuService(int ID,String name);

    /**
     * 更新 更该信息根据 id 修改密码
     * @param pwd
     * @param id
     * @return
     */
    int updStuService(String pwd,int id);

}
