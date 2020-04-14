package com.zhangjiehua.www.dao;

import com.zhangjiehua.www.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderGet {   //个人订单查看窗口专用
    private String myName;
    private String foodName;
    public int number1;
    public int number2;
    public int j;
    Connection conn;
    public String fd[] = null;

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
    public int getsNum(String name){
            String sql = "SELECT buyer,number,food FROM orders";
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {//指针向后移动
                    myName = rs.getString("buyer");
                    if (myName.equals(name)) {
                        number1++;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return number1;
        }

    public String getsFood(String name,int i){//返回食物种类
        String sql = "SELECT buyer,number,food FROM orders ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            j = 0;
            while (rs.next()) {//指针向后移动
                if (rs.getString("buyer").equals(name)) {
                    j++;
                    //System.out.println(j);
                    if(j == i){
                    foodName = rs.getString("food");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodName;
    }
    public int getsNumber(String name,int i){//返回购买的食物数量
        String sql = "SELECT buyer,number,food FROM orders ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            j = 0;
            while (rs.next()) {//指针向后移动
                myName = rs.getString("buyer");
                if (myName.equals(name)) {
                    j++;
                    if(j == i){
                    number2 = rs.getInt("number");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number2;
    }
}

