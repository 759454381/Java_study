package com.zyb.service.impl;

import com.zyb.dao.StudentDao;
import com.zyb.dao.impl.StudentDaoImpl;
import com.zyb.pojo.Student;
import com.zyb.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao sd = new StudentDaoImpl();

    /**
     * ��ѯȫ��
     * @return
     */
    @Override
    public List<Student> selAllService() {
        List<Student> students = sd.selAllDao();
        return students;
    }

    /**
     * ��½ ���������½
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
     * ע����Ϣ ע��һ��ѧ����Ϣ
     * @param student
     * @return
     */
    @Override
    public int insStuService(Student student) {
        int index = sd.insStuDao(student);
        return index;
    }

    /**
     * ɾ�� ����ID name ɾ��һ��ѧ��
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
