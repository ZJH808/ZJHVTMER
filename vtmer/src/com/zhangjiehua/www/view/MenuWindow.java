package com.zhangjiehua.www.view;

import com.zhangjiehua.www.dao.FoodGet;
import com.zhangjiehua.www.dao.Order;
import com.zhangjiehua.www.po.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuWindow extends JFrame implements MouseListener {
    public JFrame jf = new JFrame("菜单");
    private JPanel menu;
    private int distinguish;//用来记录鼠标悬停在哪个位置
    public String menuBar[][] = new Food().detailedList();
    private JButton btn01=new JButton("确认");

    public void menu(){
        jf.setSize(430, 700);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        menu = new JPanel();

        // 表头（列名）
        String[] columnNames = {"食物id", "数量" , "价格" };

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
        jf.setContentPane(menu);
        menu.add(btn01);
        btn01.addMouseListener(this);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(distinguish == 1){    //返回原来页面
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
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
