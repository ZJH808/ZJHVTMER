package com.zhangjiehua.www.po;


import com.zhangjiehua.www.dao.FoodGet;

public class Food {
    public int i;
    public int j = 3;
    public FoodGet foodGet = new FoodGet();//列出数据的方法

    public String[][] detailedList() {
        i = foodGet.choiceFood();
        String[][] menuBar = new String[i][j];
        //System.out.println(i);
        for (int number1 = 0, number2 = 1; number1 < i; number1++, number2++) {
            //  String food = foodGet.putFood(number2);
            //System.out.println(food);
            String food = foodGet.food(number2);
            int quantity = foodGet.putquantity(number2);//数据类型转化 数组存储的是String类型数据
            double price = foodGet.putPrice(number2);
            menuBar[number1][0] = food;
            menuBar[number1][1] = Integer.toString(quantity);
            menuBar[number1][2] = String.valueOf(price);
        }
            return menuBar;
        }
    }


