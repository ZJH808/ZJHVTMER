package com.zhangjiehua.www.view;

import com.zhangjiehua.www.dao.FoodGet;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QueryWindow extends JFrame implements MouseListener {
    public JFrame jf = new JFrame("订餐系统");
    private JPanel panel;
    private JButton btn01=new JButton("确定");
    private JButton btn02=new JButton("取消");
    private JLabel text=new JLabel("查找目标:");//id
    private JTextField textField=new JTextField();//文本框
    private String name;
    private int distinguish;//用来记录鼠标悬停在哪个位置
    public FoodGet foodGet = new FoodGet();

    public void queryWindow(){
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        jf.setLocationRelativeTo(null);
        panel = new JPanel(null);
        text.setBounds(10, 20, 100, 40);
        textField = new JTextField(40);
        textField.setBounds(120, 100, 165, 40);
        btn01.setBounds(100,300,100,50);
        btn02.setBounds(200,300,100,50);
        panel.add(text);
        panel.add(textField);
        panel.add(btn01);
        panel.add(btn02);
        btn01.addMouseListener(this);
        btn02.addMouseListener(this);
        jf.setContentPane(panel);
        jf.setVisible(true);//最后再设置为可显示(绘制), 所有添加的组件才会显示
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        name = textField.getText();//获取用户输入数据
        if(distinguish == 1){
            if(foodGet.food(name)){
                JOptionPane.showMessageDialog(null, "菜品存在", "提示", 2);
            }else {
                JOptionPane.showMessageDialog(null, "菜品不存在，请重新输入", "提示", 2);
            }
        }
        if(distinguish == 2){
            panel.setVisible(false);
            jf.setVisible(false);
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
}
