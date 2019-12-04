package com.neuedu.solar.common;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class FramUtil {
    public static Image getImage(String imPath){
        URL u = FramUtil.class.getClassLoader().getResource(imPath);
        BufferedImage img = null;
        try{
            img = ImageIO.read(u);
        }catch (Exception e){
            e.printStackTrace();
        }
        return img;
    }
}
