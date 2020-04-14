package com.zhangjiehua.www.view;

import com.zhangjiehua.www.po.Food;
import com.zhangjiehua.www.po.Orders;
import com.zhangjiehua.www.po.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrderInterface extends JFrame implements MouseListener {//查看历史订单窗口
    public String orders[][] ;
    private int distinguish;//用来记录鼠标悬停在哪个位置
    private JButton btn01=new JButton("确定");
    public  JFrame jf = new JFrame("历史订单");
    public JPanel order = new JPanel();

    public void orderWindow(String orders[][]){
        jf.setSize(430, 700);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        order = new JPanel();
        String[] columnNames = {"食物id","数量" };
        JTable table = new JTable(orders, columnNames);
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
        order.add(scrollPane);

        // 设置 内容面板 到 窗口
        jf.setContentPane(order);
        order.add(btn01);

        btn01.addMouseListener(this);
        jf.setContentPane(order);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        order.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(distinguish == 1){
            order.setVisible(false);
            jf.setVisible(false);
            JTable table = null;
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
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public int getDistinguish(){
        return distinguish;
    }
}
