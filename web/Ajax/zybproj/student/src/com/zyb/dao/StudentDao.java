package com.zyb.dao;

import com.zyb.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * ��ѯ����ѧ��
     * @return
     */
    List<Student> selAllDao();

    /**
     * ͨ�������������ѯ��ѧ����Ϣ
     * @param name
     * @param psw
     * @return Student
     */
    Student selByNamePswDao(String name,String psw);

    /**
     * ע��һ��ѧ��
     *
     * @param student
     * @return
     */
    int insStuDao(Student student);

    /**
     * ɾ����Ա
     * @param ID
     * @param name
     * @return
     */
    int delStuDao(int ID,String name);

    int updStuDao(String pwd,int id);

}
