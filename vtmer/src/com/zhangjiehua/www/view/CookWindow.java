package com.zhangjiehua.www.view;

import com.zhangjiehua.www.dao.Cook;
import com.zhangjiehua.www.dao.FoodGet;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CookWindow extends JFrame implements MouseListener {
    public JFrame jf = new JFrame("订餐系统");
    private JPanel panel;
    private JButton btn01 = new JButton("菜单");
    private JButton btn02 = new JButton("确定添加");
   // private JButton btn03 = new JButton("确定删除");
    private JLabel text1 = new JLabel("新添加的菜单:");//
    private JTextField text1Field=new JTextField();//文本框
    private JLabel text2 = new JLabel("添加的数量:");//
    private JLabel text4 = new JLabel("删除的菜单:");
    private JTextField text2Field=new JTextField();//文本框
    private JTextField text4Field=new JTextField();//文本框
    private JLabel text3 = new JLabel("设定价格:");
    private JTextField text3Field=new JTextField();//文本框
    private String addMenu;
    private String number;
    private String price;
    private String deleteMenu;
    private int distinguish;//用来记录鼠标悬停在哪个位置
    public FoodGet foodGet = new FoodGet();
    public Cook cook = new Cook();
    public MenuWindow menuWindow = new MenuWindow();

    public void cookWindow(){
        jf.setSize(600, 600);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        jf.setLocationRelativeTo(null);
        panel = new JPanel(null);
        text1.setBounds(10, 60, 100, 25);
        text1Field = new JTextField(20);
        text1Field.setBounds(200, 60, 165, 25);

        text2Field = new JTextField(20);
        text2.setBounds(10,120,80,25);
        text2Field.setBounds(200,120,165,25);

        text3.setBounds(10,180,165,25);
        text3Field = new JTextField(20);
        text3Field.setBounds(200,180,165,25);

        text4.setBounds(10,300,80,25);
        text4Field = new JTextField(20);
        text4Field.setBounds(200,300,165,25);

        btn02.setBounds(400,120,100,50);
       // btn03.setBounds(400,300,100,50);
        btn01.setBounds(100,500,100,50);
        panel.add(text1);
        panel.add(text1Field);
        panel.add(text2);
        panel.add(text2Field);
        panel.add(text3);
        panel.add(text3Field);
        //panel.add(text4);
       // panel.add(text4Field);
        panel.add(btn01);
        panel.add(btn02);
      //  panel.add(btn03);
        btn01.addMouseListener(this);
        btn02.addMouseListener(this);
       // btn03.addMouseListener(this);
        jf.setContentPane(panel);
        jf.setVisible(true);//最后再设置为可显示(绘制), 所有添加的组件才会显示
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            addMenu = text1Field.getText();
            number = text2Field.getText();
            price = text3Field.getText();
            deleteMenu = text4Field.getText();
            if(distinguish == 2){
                if("".equals(addMenu)||"".equals(number)||"".equals(price)){
                    JOptionPane.showMessageDialog(null, "设置失败,输入信息有误", "提示", 2);
                }else{
                    int num1 = Integer.parseInt(number);
                    double Price = Double.parseDouble(price);
                    cook.register(addMenu,num1,Price);
                    JOptionPane.showMessageDialog(null, "设置成功", "提示", 2);
                    text1Field.setText("");
                    text2Field.setText("");
                    text3Field.setText("");
                }
            }/*if(distinguish == 3){
                if(cook.food(deleteMenu)) {
                    cook.delete(deleteMenu);
                    JOptionPane.showMessageDialog(null, "删除成功", "提示", 2);
                    text4Field.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "数据不存在", "提示", 2);
                }}*/       //删除功能还不能使用
        if(distinguish == 1){
                menuWindow.menu();
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
       /* if (e.getSource() == btn03) {
            distinguish = 3;
        }*/
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
