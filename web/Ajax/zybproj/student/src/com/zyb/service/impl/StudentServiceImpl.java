package com.zyb.service.impl;

import com.zyb.dao.StudentDao;
import com.zyb.dao.impl.StudentDaoImpl;
import com.zyb.pojo.Student;
import com.zyb.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao sd = new StudentDaoImpl();
    @Override
    public List<Student> selAllService() {
        List<Student> students = sd.selAllDao();
        return students;
    }
}
