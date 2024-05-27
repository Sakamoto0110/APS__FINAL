package com.neko.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Spritesheet {
    
    public int sprite_width;
    public int sprite_height;
    public BufferedImage img;
    
    // sx is the horizontal count
    // sy is the vertical count
    public Spritesheet(String img_path, int sw, int sh) {
        try{
            img = ImageIO.read(new File(img_path));
            sprite_width = sw;
            sprite_height = sh;
        }catch(IOException e){
            System.out.println("Error loading image " + img_path);
        }
        
    }
    public Spritesheet(int w, int h, int sw, int sh) {
        img = new BufferedImage(w*sw, h*sh, BufferedImage.TYPE_INT_ARGB);
    }
    public Spritesheet(BufferedImage _img, int sw, int sh) {
        img =_img;
        sprite_width = sw;
        sprite_height = sh;
    }
    
    
    
    
    public Spritesheet(Spritesheet src, int x, int y, int width, int height, int sw, int sh) {
        int _x = x*sw * (width);
        int _y = y*sh * (height);
        img = src.img.getSubimage(_x,_y, width*sw, height*sh);
        sprite_width = sw;
        sprite_height = sh;
    }
    
    public ArrayList<BufferedImage> GetSprites() {
        int cols = img.getWidth()/sprite_width;
        int rows = img.getHeight()/sprite_height;
        ArrayList<BufferedImage> sprites = new ArrayList<>(rows*cols);
        for(int y = 0; y < rows; y++){
            for(int x = 0; x < cols; x++){
                sprites.add(x+y*rows,img.getSubimage(x*sprite_width, y*sprite_height, sprite_width, sprite_height));
            }
        }
        return sprites;
    }
    
    public BufferedImage GetSprite(int x, int y){
        return img.getSubimage(x*sprite_width, y*sprite_height, sprite_width, sprite_height);
    }
    
    
}
