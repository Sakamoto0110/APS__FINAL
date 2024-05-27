package com.neko.game;

import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Image;
import com.aspose.imaging.extensions.ImageExtensions;
import com.neko.graphics.ISprite;
import com.neko.graphics.Sprite;
import com.neko.graphics.SpriteAnimation;
import com.neko.graphics.Spritesheet;
import com.neko.resources.Resources;
import com.neko.utils.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.aspose.imaging.RotateFlipType.*;

public class Prop extends GameObject{
    
    private SpriteAnimation die = new SpriteAnimation(Resources.slime_die.GetSprites());
    private SpriteAnimation idle = new SpriteAnimation(Resources.slime_idle.GetSprites());
    private int counter = 0;
    private int counter1 = 0;
    public boolean is_dying = false;
    public Prop(String _name, ISprite _sprite, int _x, int _y, int _width, int _height){
        super(_name, _sprite, _x, _y, _width, _height);
        super.scale = 1.6f;
        super.sprite = idle;
        
    }
    
     void Kill(){
        is_dying = true;
        super.sprite = die;
        
    }
    boolean is_borning;
    void Born(int x, int y){
        is_borning = true;
        is_dying = false;
        super.is_dead = false;
        super.position = new Vector2(x,y);
        invencible = true;
     
       
        
    }
    boolean invencible = false;
    int i = 300;
    @Override
    public void Render(Graphics g){
        if(invencible){
            if(--i <= 0){
                i = 180;
                invencible = false;
            }
        }

    
        if(++counter%15 == 0){
            
            if(is_borning){
                
                die.sprites.Go_Back();
                if(counter1-- <= 0){
                    is_borning = false;
                    super.sprite = idle;
                }
                
            }
            
            
            idle.Step();
            if(is_dying){
                die.Step();
                if(++counter1 % 5 == 0){
                    super.is_dead = true;
                }
            }
                
                
        }
        
        super.Render(g);
    }
}
