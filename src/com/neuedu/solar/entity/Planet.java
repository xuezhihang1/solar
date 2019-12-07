package com.neuedu.solar.entity;

import com.neuedu.solar.common.FrameUtil;
import com.neuedu.solar.constant.Constant;
import com.neuedu.solar.common.CommonFrame;

import java.awt.*;

public class Planet {
    // 半长轴
    int longAxis ;
    // 半短轴
    int shortAxis ;
    // x轴坐标
    int x;
    // y轴坐标
    int y;
    //参数
    double theta;
    // 速度（线速度斜率的改变量）
    double speed;
    // 行星图片
    Image img;
    // 行星名称
    String name;
    // 行星是否逆向运行
    boolean ni;
    Sun sun;
    int width;
    int height;
    public Planet(){}
    public Planet(Sun sun,String name,double AU,int T,double e,String imgPath,boolean ni){
        this.sun = sun;
        this.name = name;
        this.longAxis = getLongAxis(AU);
        this.shortAxis = getShortAxis(AU,e);
        this.speed = getSpeed(T);
        this.img = FrameUtil.getImage(imgPath);
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this. ni = ni ;
    }

    /**
     * 旋转速度
     * @param t 周期
     * @return
     */
    private double getSpeed(int t) {
        return 365.0 / t * 0.1;
    }

    /**
     * 半短轴长度转换
     * @param au 天文单位
     * @param e 离心率
     * @return 半长轴长度
     */
    private int getShortAxis(double au, double e) {
        return (int)(this.longAxis*Math.sqrt(1 - Math.pow(e,2))/2);
    }



    /**
     * 半长轴长度换算
     * @param au 天文单位
     * @return 半长轴长度
     */
    private int getLongAxis(double au) {
        return (int)(au*100);
    }

    /**
     * 画行星
     */
    public void draw(Graphics g){
        drawTrace(g);
        g.drawImage(img,x,y,null);
        move();
    }
    //画小行星带
    public void draws(Graphics g){
        g.drawImage(img, x, y, null);
        move();
    }
    //画哈雷彗星
    public void drawss(Graphics g){
        g.drawImage(img,x,y,null);
        move2();
    }
    /**
     *运行轨迹
     */
    private void move(){
        if(ni){
            x = (sun.x + sun.width / 2 - this.width / 2 + (int)(longAxis * Math.sin(theta)));
            y = (sun.y + sun.height / 2 - this.height / 2 + (int)(shortAxis * Math.cos(theta)));
            theta += speed;
        }else {
            x = (sun.x + sun.width / 2 - this.width / 2 + (int)(longAxis * Math.cos(theta)));
            y = (sun.y + sun.height / 2 - this.height / 2 + (int)(shortAxis * Math.sin(theta)));
            theta += speed;
        }
    }
    private void move2(){//哈雷移动
        x = sun.x +sun.width/2-this.width /2+ (int)(longAxis * Math.sin(theta)-(shortAxis* Math.cos(theta)));
        y = sun.y +sun.height/2-this.height /2 + (int)(shortAxis* Math.cos(theta)+longAxis * Math.sin(theta));
        theta += speed;
    }

    /**
     * 画轨道
     * @param g
     */
    private void drawTrace(Graphics g){
        int x = sun.x +sun.width / 2 - longAxis;
        int y = sun.y + sun.height /2 - shortAxis;
        int width = 2 * longAxis;
        int height = 2 * shortAxis;
        g.drawOval(x,y,width,height);
        g.drawString(name,this.x,this.y);
    }

}
