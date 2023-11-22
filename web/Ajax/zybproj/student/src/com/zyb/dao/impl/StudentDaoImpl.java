package com.zyb.dao.impl;

import com.zyb.dao.StudentDao;
import com.zyb.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    //查询全部
    @Override
    public List<Student> selAllDao() {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        List<Student> ls=null;
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //创建sql命令
            String sql = "select * from student";
//            String sql = "select id,pwd,name,age,if(gender='男',1,0) from student";    // 如果个gender 是男的 转换为1，不是为0
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //执行sql
            rs = ps.executeQuery();
            //给集合赋值
            ls = new ArrayList<Student>();
            //遍历结果
            while(rs.next()){
                //给变量赋值
                Student stu =new Student();
                stu.setId(rs.getInt("id"));
                stu.setPwd(rs.getString("pwd"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
//                stu.setGender(rs.getString("gender"));
                stu.setGender(rs.getString(5));
                //将对象存储到集合中
                ls.add(stu);
            }


            //将对象存储到集合中
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
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

        //返回结果
        return ls;
    }

    //查询 通过密码姓名 查询个人信息
    @Override
    public Student selByNamePswDao(String name, String psw) {
        //声明 JDBC 对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //创建实体类对象
        Student stu = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //创建 SQL 语句
//            System.out.println("赋值前！");
            String sql = "select * from student where name=? and pwd=?";
            //创建 SQL 命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1,name);
            ps.setString(2,psw);
            //执行
            rs = ps.executeQuery();
            //循环遍历
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
            //关闭资源
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

    // 添加用户信息
    @Override
    public int insStuDao(Student student) {
        //声明 JDBC 对象
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //创建 SQL 语句
//            System.out.println("赋值前！");
//            String sql = "insert into student (id,name,pwd,age,gender) values (default,?,?,?,?)";
            String sql = "insert into student values (default,?,?,?,?)";
            //创建 SQL 命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
//            ps.setInt(1,student.getId());
            ps.setString(1,student.getName());
            ps.setString(2,student.getPwd());
            ps.setInt(3,student.getAge());
            ps.setString(4,student.getGender());

            //执行
            index = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
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

    //删除信息 通过id name
    @Override
    public int delStuDao(int ID, String name) {
        //声明 JDBC 对象
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //创建 SQL 语句
//            System.out.println("赋值前！");
//            String sql = "insert into student (id,name,pwd,age,gender) values (default,?,?,?,?)";
            String sql = "delete from student where id=? and name=?";
            //创建 SQL 命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setInt(1,ID);
            ps.setString(2,name);
            //执行
            index = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
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

    // 更改用户信息 通过id 修改密码
    @Override
    public int updStuDao(String pwd, int id) {
        //声明 JDBC 对象
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","admin");
            //创建 SQL 语句
//            System.out.println("赋值前！");
//            String sql = "insert into student (id,name,pwd,age,gender) values (default,?,?,?,?)";
            String sql = "update student set pwd=? where id=?";
            //创建 SQL 命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1,pwd);
            ps.setInt(2,id);
            //执行
            index = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
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
