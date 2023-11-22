package com.zyb.service.impl;

import com.zyb.dao.StudentDao;
import com.zyb.dao.impl.StudentDaoImpl;
import com.zyb.pojo.Student;
import com.zyb.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao sd = new StudentDaoImpl();

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Student> selAllService() {
        List<Student> students = sd.selAllDao();
        return students;
    }

    /**
     * 登陆 姓名密码登陆
     * @param name
     * @param psw
     * @return
     */
    @Override
    public Student selByNamePswService(String name, String psw) {
        Student student = sd.selByNamePswDao(name, psw);
        return student;
    }

    /**
     * 注册信息 注册一个学生信息
     * @param student
     * @return
     */
    @Override
    public int insStuService(Student student) {
        int index = sd.insStuDao(student);
        return index;
    }

    /**
     * 删除 根据ID name 删除一个学生
     * @param ID
     * @param name
     * @return
     */
    @Override
    public int delStuService(int ID, String name) {
        int index = sd.delStuDao(ID, name);
        return index;
    }

    @Override
    public int updStuService(String pwd, int id) {
        int index = sd.updStuDao(pwd, id);
        return index;
    }

}
