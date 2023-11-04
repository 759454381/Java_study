package com.zyb.dao;

import com.zyb.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> selAllDao();
}
