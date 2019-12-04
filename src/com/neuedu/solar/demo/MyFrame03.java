package com.neuedu.solar.demo;

import com.neuedu.solar.common.CommonFrame;
import com.neuedu.solar.common.FramUtil;
import com.neuedu.solar.constant.Constant;

import java.awt.*;

public class MyFrame03 extends CommonFrame {
    //半长轴
    int longAxis = 400;
    //半短轴
    int shortAxis = 200;
    //参数theta
    double theta = 0.0;
    int x;
    int y;

    double speed = 0.1;
    static Image img = FramUtil.getImage("com/neuedu/solar/img/Earth.png");

    public void paint(Graphics g){
        //椭圆轨迹
        g.drawImage(img,x,y,50,50,null);
        x = (int)( Constant.FRAME_WIDTH / 2 +longAxis * Math.cos(theta));
        y =  (int)(Constant.FRAME_HEIGHT / 2 +shortAxis * Math.sin(theta));
        theta += speed;
    }
    public static void main(String[] args){
        MyFrame03 myFrame03 = new MyFrame03();
        myFrame03.loadFrame("按照椭圆轨迹运行");
    }
}
