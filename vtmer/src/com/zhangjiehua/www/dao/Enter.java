package com.zhangjiehua.www.dao;


import com.zhangjiehua.www.util.JDBCUtils;

import java.sql.*;


public class Enter {
    private String name;
    private String password;
    Connection conn;
    private int number1=0;
    private int number2=0;

    {
        try {
            conn = JDBCUtils.getConnetion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Statement stmt;

    {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                //用户登录
    public boolean selectName(String myName) {

        String sql = "select username,password from users";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                name = rs.getString("username");
                number1++;
                if (name.equals(myName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        public boolean selectPassword(String myPassword) {

        String sql = "select username,password from users";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                password = rs.getString("password");
                number2++;
                if (password.equals(myPassword) && number1 == number2) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //厨师登录
    public boolean selectCook(String myName) {

        String sql = "select cook,password from cooks";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                name = rs.getString("cook");
                number1++;
                if (name.equals(myName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean selectCookPassword(String myPassword) {

        String sql = "select cook,password from cooks";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                password = rs.getString("password");
                number2++;
                if (password.equals(myPassword)&& number1 == number2) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void register(String name,String password){//用户注册
        try{
            String userName = name;
            String Password= password;
            String sql="INSERT INTO users(username,password)VALUES('"+userName+"','"+Password+"')";
            stmt.executeUpdate(sql);//更新语句
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }


        public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }

    public void setNumber1(){
        number1=0;
    }
    public void setNumber2(){
        number2=0;
    }





}













