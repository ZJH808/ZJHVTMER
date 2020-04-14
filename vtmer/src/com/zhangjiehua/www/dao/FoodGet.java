package com.zhangjiehua.www.dao;

import com.zhangjiehua.www.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodGet {
    private String food;
    private int num;
    public int number1;
    private double price;
    private int quantity;
    Connection conn;

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
    public boolean food(String name){
        String sql = "SELECT fid,foodname,number,price FROM food";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                if(rs.getString("foodname").equals(name)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int choiceFood() {        //查询食物列表中有多少个数据
        String sql = "SELECT fid,foodname,number,price FROM food";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                number1++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number1;
    }

    public String food(int number) {        //返回食物名称,数据库中设计的id是从1开始并且自动增长的 所以能按顺序输出食物名称
        String sql = "SELECT fid,foodname,number,price FROM food";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                num = rs.getInt("fid");
                if(number == num){
                    food = rs.getString("foodname");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }
    public int putquantity(int number) {        //返回食物价格,数据库中设计的id是从1开始并且自动增长的 所以能按顺序输出食物的价格
        String sql = "SELECT fid,foodname,number,price FROM food";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                num = rs.getInt("fid");
                if(number == num){
                    quantity = rs.getInt("number");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
    public double putPrice(int number) {        //返回食物价格,数据库中设计的id是从1开始并且自动增长的 所以能按顺序输出食物的数量
        String sql = "SELECT fid,foodname,number,price FROM food";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {//指针向后移动
                num = rs.getInt("fid");
                if(number == num){
                    price = rs.getDouble("price");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

}
