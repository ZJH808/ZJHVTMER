package com.zhangjiehua.www.view;

import com.zhangjiehua.www.dao.FoodGet;
import com.zhangjiehua.www.dao.Order;
import com.zhangjiehua.www.po.Food;
import com.zhangjiehua.www.po.Orders;
import com.zhangjiehua.www.po.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FoodMenu extends JFrame implements MouseListener {
    public FoodGet foodGet = new FoodGet();//列出数据的方法
    public JFrame jf = new JFrame("菜单");
    private JButton btn01=new JButton("确认订餐");
    private JButton btn02=new JButton("取消订餐");
    private JLabel food = new JLabel("选择食物：");
    private JLabel number = new JLabel("选择的数量: ");
    private JTextField foodField=new JTextField();
    private JTextField numberField=new JTextField();
    private JPanel menu;
    private int distinguish;//用来记录鼠标悬停在哪个位置
    private String foodName;
    private String amount;
    public Order order = new Order();//  调用Order中的方法
    public String menuBar[][] = new Food().detailedList();

    public void menu(){
        jf.setSize(430, 700);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        menu = new JPanel();
        foodField = new JTextField(20);
        numberField = new JTextField(20);
        food.setBounds(300,700,80,25);
        foodField.setBounds(400,700,200,25);
        number.setBounds(300,700,80,25);
        numberField.setBounds(400,700,200,25);
        btn01.setBounds(200,900,100,50);
        btn02.setBounds(400,900,100,50);

        ;
        // 表头（列名）
        String[] columnNames = {"食物id", "数量" , "价格" };

        // 表格所有行数据
       /* i = foodGet.choiceFood();
        String menuBar[][] = new String[i][j];
        //System.out.println(i);
        for(int number1 = 0,number2 = 1;number1 < i; number1++ ,number2++){
            String food = foodGet.putFood(number2);
            //System.out.println(food);
            int quantity = foodGet.putquantity(number2);//数据类型转化 数组存储的是String类型数据
            double price = foodGet.putPrice(number2);
            menuBar[number1][0] = food;
            menuBar[number1][1] = Integer.toString(quantity);
            menuBar[number1][2] = String.valueOf(price);
        }
        /*for(int a=0;a< i;a++){
            for(int b=0;b<3;b++){
                System.out.println(menuBar[a][b]);
            }
        }*/

        // 创建一个表格，指定 表头 和 所有行数据
        JTable table = new JTable(menuBar, columnNames);

        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(30);

        // 第一列列宽设置为40
        table.getColumnModel().getColumn(0).setPreferredWidth(40);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加 滚动面板 到 内容面板
        menu.add(scrollPane);

        // 设置 内容面板 到 窗口
        jf.setContentPane(menu);

        menu.add(food);
        menu.add(foodField);
        menu.add(number);
        menu.add(numberField);
        menu.add(btn01);
        menu.add(btn02);
        btn01.addMouseListener(this);
        btn02.addMouseListener(this);
        jf.setContentPane(menu);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        foodName = foodField.getText();//获取输入文本框中的内容
        amount = numberField.getText();
        String use;
        use = new User().username;//查看当前用户
        //System.out.println(USe);
        if(distinguish == 1){//确认订单 执行程序 返回原来页面
            int quantity = Integer.parseInt(amount);
            if(order.foodEnough(quantity)) {
                if(order.foodRight(foodName)){
                order.orderFood(use,quantity,foodName);//输入到数据库中
                int surplus = order.surplus(foodName) - quantity;
                if(surplus >= 0 ){
                  //  System.out.println(surplus);
                order.decrease(surplus,foodName);
                JOptionPane.showMessageDialog(null, "购买成功", "提示", 2);
                foodField.setText("");
                numberField.setText("");
                distinguish = 3;
                menu.setVisible(false);
                jf.setVisible(false);//购买成功则关闭界面
                }else{
                    JOptionPane.showMessageDialog(null, "菜品剩余量不足", "提示", 2);
                    foodField.setText("");
                    numberField.setText("");
                }

            }else {
                    JOptionPane.showMessageDialog(null, "没有这种菜", "提示", 2);
                    foodField.setText("");
                    numberField.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null, "库存不足", "提示", 2);
                foodField.setText("");
                numberField.setText("");
            }

        }
        if(distinguish == 2){    //取消订单 返回原来页面
            menu.setVisible(false);
            jf.setVisible(false);//关闭界面
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == btn01) {
            distinguish = 1;//鼠标悬停在btn01处则把distinguish置1
        }
        if (e.getSource() == btn02) {
            distinguish = 2;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public int getDistinguish(){
        return distinguish;
    }
    public String getFoodName(){
        return foodName;
    }
    public String getAmount(){
        return amount;
    }
}
