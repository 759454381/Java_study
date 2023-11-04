package com.zyb.dao.impl;

import com.zyb.dao.StudentDao;
import com.zyb.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selAllDao() {
        //����jdbc����
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //��������
        List<Student> ls=null;
        //��������
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //����sql����
//            String sql = "select * from student";
            String sql = "select id,pwd,name,age,if(gender='��',1,0) from student";
            //����sql�������
            ps = conn.prepareStatement(sql);
            //ִ��sql
            rs = ps.executeQuery();
            //�����ϸ�ֵ
            ls = new ArrayList<Student>();
            //�������
            while(rs.next()){
                //��������ֵ
                Student stu =new Student();
                stu.setId(rs.getInt("id"));
                stu.setPwd(rs.getString("pwd"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
//                stu.setGender(rs.getString("gender"));
                stu.setGender(rs.getString(5));
                //������洢��������
                ls.add(stu);
;            }


            //������洢��������
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //�ر���Դ
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //���ؽ��
        return ls;
    }
}
