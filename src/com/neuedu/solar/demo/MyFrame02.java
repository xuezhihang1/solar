package com.neuedu.solar.demo;

import com.neuedu.solar.common.CommonFrame;
import com.neuedu.solar.common.FrameUtil;

import java.awt.*;


public class MyFrame02 extends CommonFrame {
    int x=400;
    int y=400;
    int speed=10;
    public void paint(Graphics g){
        g.drawImage(FrameUtil.getImage("com/neuedu/solar/img/Earth.jpg"),x,y,80,80,null);
        x+=speed;
    }

    public static void main(String[] args) {
        MyFrame02 myFrame02=new MyFrame02();
        myFrame02.loadFrame("第二个窗口");
    }
}
