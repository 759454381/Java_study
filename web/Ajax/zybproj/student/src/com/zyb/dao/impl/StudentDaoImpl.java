package com.zyb.dao.impl;

import com.zyb.dao.StudentDao;
import com.zyb.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

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
//            String sql = "select * from student";
            String sql = "select id,pwd,name,age,if(gender='男',1,0) from student";
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
;            }


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
}
