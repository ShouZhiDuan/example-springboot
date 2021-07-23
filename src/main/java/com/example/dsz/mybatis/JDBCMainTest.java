package com.example.dsz.mybatis;

import java.sql.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/11 16:39
 * @Description:
 */
public class JDBCMainTest {

    /**
     * 地址：192.168.10.30
     * 数据库：demo
     * 用户名：root
     * 密码：Wentiliangkaihua@hz
     *
     * @param args
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://192.168.10.30:3306/demo", "root", "Wentiliangkaihua@hz");
        PreparedStatement preparedStatement = root.prepareStatement("select * from  demo_test");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }


}
