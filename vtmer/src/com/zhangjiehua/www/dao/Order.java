package com.zhangjiehua.www.dao;

import com.zhangjiehua.www.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Order {
    private String Food;
    Connection conn;
    private int number;
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
    public boolean foodEnough(int quantity){   //查看食物是否充足
        String sql = "SELECT fid,foodname,number,price FROM food ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                number = rs.getInt("number");
                if (number >= quantity) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean foodRight(String foodName){    // 查看食物是否存在
        String sql = "SELECT fid,foodname,number,price FROM food ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                Food = rs.getString("foodname");
                if (Food.equals(foodName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
                            // 确认订单
    public void orderFood(String user,int number, String foodName){
        try {
            String sql = "INSERT INTO orders(buyer,number,food)VALUES('"+user+"','"+number+"','"+foodName+"')";
            stmt.executeUpdate(sql);//更新语句
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
    public void decrease(int num,String foodName){
        try {
            //System.out.println(foodName);
            //System.out.println(num);
            String sql = "UPDATE food SET number = '"+num+"' WHERE foodname = '"+foodName+"'";
            stmt.executeUpdate(sql);//更新语句
        } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public int surplus(String foodName){
        String sql = "SELECT fid,foodname,number,price FROM food ";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                Food = rs.getString("foodname");
                number = rs.getInt("number");
                if (Food.equals(foodName)) {
                    return number;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
    }
        return 0;
    }

}

