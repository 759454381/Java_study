package com.zyb.dao.impl;

import com.zyb.dao.StudentDao;
import com.zyb.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    //��ѯȫ��
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
            String sql = "select * from student";
//            String sql = "select id,pwd,name,age,if(gender='��',1,0) from student";    // �����gender ���е� ת��Ϊ1������Ϊ0
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
            }


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

    //��ѯ ͨ���������� ��ѯ������Ϣ
    @Override
    public Student selByNamePswDao(String name, String psw) {
        //���� JDBC ����
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //����ʵ�������
        Student stu = null;
        try {
            //��������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //���� SQL ���
//            System.out.println("��ֵǰ��");
            String sql = "select * from student where name=? and pwd=?";
            //���� SQL �������
            ps = conn.prepareStatement(sql);
            // ��ռλ����ֵ
            ps.setString(1,name);
            ps.setString(2,psw);
            //ִ��
            rs = ps.executeQuery();
            //ѭ������
                while(rs.next()){
                    stu =new Student();
                    stu.setId(rs.getInt("id"));
                    stu.setName(rs.getString("name"));
                    stu.setPwd(rs.getString("pwd"));
                    stu.setAge(rs.getInt("age"));
                    stu.setGender(rs.getString("gender"));
                }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stu;
    }

    // ����û���Ϣ
    @Override
    public int insStuDao(Student student) {
        //���� JDBC ����
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            //��������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //���� SQL ���
//            System.out.println("��ֵǰ��");
//            String sql = "insert into student (id,name,pwd,age,gender) values (default,?,?,?,?)";
            String sql = "insert into student values (default,?,?,?,?)";
            //���� SQL �������
            ps = conn.prepareStatement(sql);
            // ��ռλ����ֵ
//            ps.setInt(1,student.getId());
            ps.setString(1,student.getName());
            ps.setString(2,student.getPwd());
            ps.setInt(3,student.getAge());
            ps.setString(4,student.getGender());

            //ִ��
            index = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }

    //ɾ����Ϣ ͨ��id name
    @Override
    public int delStuDao(int ID, String name) {
        //���� JDBC ����
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            //��������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //���� SQL ���
//            System.out.println("��ֵǰ��");
//            String sql = "insert into student (id,name,pwd,age,gender) values (default,?,?,?,?)";
            String sql = "delete from student where id=? and name=?";
            //���� SQL �������
            ps = conn.prepareStatement(sql);
            // ��ռλ����ֵ
            ps.setInt(1,ID);
            ps.setString(2,name);
            //ִ��
            index = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }

    // �����û���Ϣ ͨ��id �޸�����
    @Override
    public int updStuDao(String pwd, int id) {
        //���� JDBC ����
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            //��������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //���� SQL ���
//            System.out.println("��ֵǰ��");
//            String sql = "insert into student (id,name,pwd,age,gender) values (default,?,?,?,?)";
            String sql = "update student set pwd=? where id=?";
            //���� SQL �������
            ps = conn.prepareStatement(sql);
            // ��ռλ����ֵ
            ps.setString(1,pwd);
            ps.setInt(2,id);
            //ִ��
            index = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }

}
