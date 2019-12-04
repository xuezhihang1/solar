package com.neuedu.solar.demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public MyFrame(){
        //设置大小
        this.setSize(1200,800);
        //设置位置
//        this.setLocation(50,50);
        this.setLocationRelativeTo(null);
        //设置可见性
        this.setVisible(true);
        //设置关闭窗口的方法实现
        //使用匿名内部类完成抽象类对象的创建
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //设置改变窗口大小的方法
        this.setResizable(false);
        //设置题目
        this.setTitle("第一个窗口");
    }
    public void paint(Graphics g){
        //画直线
//        g.drawLine(50,50,200,200);
//        //画矩形
//        g.drawRect(200,200,400,400);
//        //画圆
//        g.drawOval(300,300,400,400);
        //获取系统的默认颜色
//        Color c = g.getColor();
//        //改变画笔颜色
//        g.setColor(new Color(50,120,150));
//        g.fillRect(400,400,500,500);
//        g.setColor(c);
        //画不规则图形
        //画八边形
        int[] xPoints = {50,100,130,130,100,50,20,20};
        int[] yPoints = {50,50,80,110,140,140,110,80};
        int nPoints = 8;
        g.drawPolygon(xPoints,yPoints,nPoints);
        //画图片
//            g.drawImage(FramUtil.getImage("com/neuedu/solar/img/hai.jpg"),100,100,null);
    }
}
