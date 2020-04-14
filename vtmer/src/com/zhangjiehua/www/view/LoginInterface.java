package com.zhangjiehua.www.view;
import com.zhangjiehua.www.dao.Enter;
import com.zhangjiehua.www.po.Orders;
import com.zhangjiehua.www.po.User;
import com.zhangjiehua.www.util.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.zhangjiehua.www.po.Orders;

public class LoginInterface extends JFrame implements MouseListener {
    public JFrame jf = new JFrame("广工线上食堂：");
    private JPanel login;
    private JLabel userText=new JLabel("用户:");//id
    private JTextField userField=new JTextField();//文本框
    private JLabel passwordText=new JLabel("密  码:");
    private JTextField passwordField=new JTextField();
    private JButton btn01=new JButton("用户登陆");
    private JButton btn02=new JButton("用户注册");
    private JButton btn03=new JButton("厨师登录");
    public User currentUser = new User();       //设置一个当前用户
    public Enter myOpr=new Enter();

    public StudentWindow studentWindow = new StudentWindow();//调用别的窗口
  //  public Orders ord = new Orders();
    public CookWindow cook = new CookWindow();

    private String password;
    public String user;
    private int distinguish;//用来记录鼠标悬停在哪个位置

    public void test() {
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭
        jf.setLocationRelativeTo(null);
        login = new JPanel(null);

        btn01.setBounds(100, 400, 100, 50);//登录按键坐标和宽度高度
        btn02.setBounds(200, 400, 100, 50);
        btn03.setBounds(300, 400, 100, 50);
        userText.setBounds(10, 20, 80, 25);
        passwordText.setBounds(10, 50, 80, 25);
        userField = new JTextField(20);
        userField.setBounds(100, 20, 165, 25);
        passwordField = new JPasswordField(30);
        passwordField.setBounds(100, 50, 165, 25);
        login.add(passwordField);//逐个添加
        login.add(userText);
        login.add(passwordText);
        login.add(userField);
        login.add(btn01);
        login.add(btn02);
        login.add(btn03);
        btn01.addMouseListener(this);
        btn02.addMouseListener(this);
        btn03.addMouseListener(this);
        jf.setContentPane(login);
        jf.setVisible(true);//最后再设置为可显示(绘制), 所有添加的组件才会显示
    }

    public void mouseClicked(MouseEvent e) {
        password = passwordField.getText();//获取用户输入数据
        user = userField.getText();
        currentUser.inputUsername(user);
        if (distinguish == 1) {
            if (myOpr.selectName(user)) {//登录判断
                if (myOpr.selectPassword(password)) {
                    JOptionPane.showMessageDialog(null, "登陆成功", "提示", 2);
                    passwordText.setText("");
                    userField.setText("");
                    distinguish = 4;
                    login.setVisible(false);//登录成功则关闭界面
                    studentWindow.order();
                }
                else {
                    JOptionPane.showMessageDialog(null, "密码或者用户名错误", "提示", 2);
                    userField.setText("");
                    passwordField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "密码或者用户名错误", "提示", 2);
                userField.setText("");
                passwordField.setText("");
            }
        }
        if (distinguish == 2) {
            //账号注册
            String name = (String) JOptionPane.showInputDialog(null, "请输入你的id：\n", "注册", JOptionPane.PLAIN_MESSAGE, null, null, "在这里输入");
            String cipher = (String) JOptionPane.showInputDialog(null, "请输入你的密码：\n", "注册", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入");
            if ("".equals(name) && "".equals(cipher)) {
                JOptionPane.showMessageDialog(null, "注册失败", "提示", 2);
            } else {
                myOpr.register(name, cipher);
                JOptionPane.showMessageDialog(null, "注册成功", "提示", 2);
            }
        }
        if (distinguish == 3) {
            if (myOpr.selectCook(user)) {//厨师登录判断
                if (myOpr.selectCookPassword(password)) {
                    JOptionPane.showMessageDialog(null, "登陆成功", "提示", 2);
                    passwordText.setText("");
                    userField.setText("");
                    distinguish = 4;
                    login.setVisible(false);//登录成功则关闭界面
                    cook.cookWindow();
                }
                else {
                    JOptionPane.showMessageDialog(null, "密码错误", "提示", 2);
                    userField.setText("");
                    passwordField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "密码或者用户名错误", "提示", 2);
                userField.setText("");
                passwordField.setText("");
            }
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

        public void mouseExited(MouseEvent e) {

    }

        public String getText1(){
        return user;
    }
    public String getText2(){
        return password;
    }
    public int getDistinguish(){
        return distinguish;
    }
}












