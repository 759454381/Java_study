package com.zyb.service;

import com.zyb.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * ��ѯ����ѧ����Ϣ
     * @return
     */
    List<Student> selAllService();

    /**
     * ��½��ѯ
     * @param name
     * @param psw
     * @return
     */
    Student selByNamePswService(String name,String psw);

    /**
     * ע���û� ��������
     * @param student
     * @return
     */
    int insStuService(Student student);

    /**
     *ɾ��ѧ�� ���ݱ�ź�����
     * @param ID
     * @param name
     * @return
     */
    int delStuService(int ID,String name);

    /**
     * ���� ������Ϣ���� id �޸�����
     * @param pwd
     * @param id
     * @return
     */
    int updStuService(String pwd,int id);

}
