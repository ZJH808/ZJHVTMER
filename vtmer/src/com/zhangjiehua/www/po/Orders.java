package com.zhangjiehua.www.po;

import com.zhangjiehua.www.dao.OrderGet;
import com.zhangjiehua.www.po.User;

public class Orders {
    public int i ;
    public int j = 2;
    public OrderGet foodGet = new OrderGet();//列出数据的方法
    public String User;

    public String[][] detailedList(String user) {
        String[][] historicalOrder = null;
        User = user;
        i = foodGet.getsNum(User);
        historicalOrder = new String[i][j];
        //System.out.println(User);
        //System.out.println(i);
         //   int quantity = foodGet.getsNumber(User);//数据类型转化 数组存储的是String类型数据
            for(int k = 0;k < i; k++) {
                historicalOrder[k][0] = foodGet.getsFood(User,k+1);
                historicalOrder[k][1] = Integer.toString(foodGet.getsNumber(User,k+1));
            }
        //System.out.println(historicalOrder);
        return historicalOrder;
    }

}
