package com.zhangjiehua.www.view;

import com.zhangjiehua.www.po.Orders;
import com.zhangjiehua.www.po.User;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentWindow extends JFrame implements MouseListener {
    public JFrame jf = new JFrame("订餐系统");
    private JPanel canteen;
    private JButton btn01=new JButton("订餐");
    private JButton btn02=new JButton("购买记录");
    private JButton btn03=new JButton("精准搜索");
    public Orders order = new Orders();
    private int distinguish;//用来记录鼠标悬停在哪个位置

    public FoodMenu foodMenu = new FoodMenu();//食物菜单弹窗
    public OrderInterface orderInterface = new OrderInterface();//查看购买历史记录页面
    public QueryWindow queryWindow = new QueryWindow();//搜素

    public void order(){
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        jf.setLocationRelativeTo(null);
        canteen = new JPanel(null);
        btn01.setBounds(0, 0, 100, 50);
        btn02.setBounds(100, 0, 100, 50);
        btn03.setBounds(200, 0, 100, 50);
        canteen.add(btn01);
        canteen.add(btn02);
        canteen.add(btn03);
        btn01.addMouseListener(this);
        btn02.addMouseListener(this);
        btn03.addMouseListener(this);
        jf.setContentPane(canteen);
        jf.setVisible(true);//最后再设置为可显示(绘制), 所有添加的组件才会显示
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(distinguish == 1){
            foodMenu.menu();
        }
            if(distinguish == 2){
                String use;
                use = new User().username;
                String orders[][] = null;
                orders = order.detailedList(use);
                orderInterface.orderWindow(orders);
            }
            if(distinguish == 3){
                queryWindow.queryWindow();
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
        if (e.getSource() == btn03) {
            distinguish = 3;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getDistinguish(){
        return distinguish;
    }
}