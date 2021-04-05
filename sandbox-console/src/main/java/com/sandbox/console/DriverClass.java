package com.sandbox.console;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.agent.ByteBuddyAgent;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DriverClass {
    String JDriver = "com.mysql.cj.jdbc.Driver";
//    String connectDB = "jdbc:mysql://47.104.190.82:3306/ucarcrm?characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8&autoReconnect=true&allowMultiQueries=true";
    String connectDB = "jdbc:mysql://mecs.com:3306/tdatabase?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&autoReconnect=true&allowMultiQueries=true&useCursorFetch=true";
    String user = "root";
    String password = "1111";

    public static String statichello() {
        System.out.println("hello");
        return "hello";
    }

    public String dynamichello() {
        System.out.println("hello");
        return "hello";
    }


    public void todo() throws ClassNotFoundException, JsonProcessingException {
//        String connectDB = "jdbc:sqlserver://172.28.9.32;DatabaseName=UnifiedCarPlatform";
//        String connectDB = "jdbc:mysql://47.104.190.82:3306/ucarcrm?charset=utf8&useSSL=false";
        Class.forName(JDriver);
        System.out.println("数据库驱动成功");

        try {
//            ByteBuddyAgent.install();
            Connection con = DriverManager.getConnection(connectDB, user, password);
            System.out.println("连接数据库成功");
            Statement stmt = con.createStatement();
            System.out.println("开始读取数据");
            ResultSet rs = stmt.executeQuery("SELECT 1");//返回SQL语句查询结果集(集合)

            //循环输出每一条记录
            while (rs.next()) {
                //输出每个字段
                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t");
            }
            System.out.println("读取完毕");

            //关闭连接
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("数据库连接错误");
            System.exit(0);
        }
    }
}
