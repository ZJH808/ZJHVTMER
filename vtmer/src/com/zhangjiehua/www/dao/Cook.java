package com.zhangjiehua.www.dao;

import com.zhangjiehua.www.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cook {
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
    public void register(String name,int number1,double price){//添加菜
        try{
            String foodName = name;
            int num1 = number1;
            Double Price = price;
            String sql="INSERT INTO food(foodname,number,price)VALUES('"+foodName+"','"+num1+"','"+Price+"')";
            stmt.executeUpdate(sql);//更新语句
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
    //查找食物是否存在
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
    public void delete(String name){// 删除内容
            String sql = "DELETE FROM food WHERE foodname = '"+name+"' ";
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
