package com.neuedu.solar.client;

import com.neuedu.solar.common.CommonFrame;
import com.neuedu.solar.common.FrameUtil;
import com.neuedu.solar.constant.Constant;
import com.neuedu.solar.entity.Planet;
import com.neuedu.solar.entity.Sun;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SolarSystem extends CommonFrame {
    Sun sun = new Sun();
    Planet Mercury = new Planet(sun,"水星",0.387,88,0.2056,"com/neuedu/solar/img/ShuiMercury.png",false);
    Planet Venus = new Planet(sun,"金星",0.72,225,0.0068,"com/neuedu/solar/img/JinVenus.png",true);
    Planet Earth = new Planet(sun,"地球",1,365,0.0167,"com/neuedu/solar/img/Earth.png",false);
    Planet Mars = new Planet(sun,"火星",2.02,687,0.0934,"com/neuedu/solar/img/HuoMars.png",false);
    Planet Juspiter = new Planet(sun,"木星",4.0,4330,0.0489,"com/neuedu/solar/img/MuJupiter.png",false);
    Planet Satun = new Planet(sun,"土星",5.04,10832,0.0557,"com/neuedu/solar/img/TuSaturn.png",false);
    Planet Uranus = new Planet(sun,"天王星",5.8,30777,0.0444,"com/neuedu/solar/img/TianUranus.png",false);
    Planet Neptune = new Planet(sun,"海王星",6.4,60328,0.0112,"com/neuedu/solar/img/HaiNeptune.png",false);
    Planet Ming = new Planet(sun,"冥王星",7.0,90917,0.249,"com/neuedu/solar/img/ming.png",false);
    Planet halei = new Planet (sun,"哈雷彗星",3.68,900,0.249,"com/neuedu/solar/img/ShuiMercury.png",false);

    List<Planet> smallPlanets = new ArrayList<Planet>();

    {
        for(int i = 0;i < 100;i++){
            double q = (Math.random() + 2.04) + Math.random() * 0.8;
            int qq = (int) (Math.random() + 687 + (Math.random() * 3000));
            double qqq = Math.random() * 0.08;
            Planet smallPlent = new Planet(sun, "", q, qq, qqq, "com/neuedu/solar/img/ShuiMercury.png", false);
            smallPlanets.add(smallPlent);
        }
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(FrameUtil.getImage("yuzhou.jpg"), 0, 0, Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT, null);
        sun.draw(g);
        Mercury.draw(g);
        Venus.draw(g);
        Earth.draw(g);
        Mars.draw(g);
        for (int i = 0; i < smallPlanets.size(); i++) {
            Planet p = smallPlanets.get(i);
            p.draws(g);
        }
        Juspiter.draw(g);
        Satun.draw(g);
        Uranus.draw(g);
        Neptune.draw(g);
        Ming.draw(g);
        halei.drawss (g);
    }

    public static void main(String[] args){
        new SolarSystem().loadFrame("太阳系八大行星运行");
    }
}
