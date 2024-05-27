package com.neko.game;

import com.neko.graphics.ISprite;
import com.neko.graphics.Sprite;
import com.neko.graphics.SpriteAnimation;
import com.neko.graphics.Spritesheet;
import com.neko.resources.Resources;
import com.neko.utils.Vector2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_F3;
import static java.awt.event.KeyEvent.VK_F4;

public class Player extends GameObject implements IGameObject , KeyListener{
   
    
    private int counter = 0;
    
    
    // -1 idle
    // 0 top
    // 1 down
    // 2 left
    // 3 right
    private int dir = 0;
    
    
    private final SpriteAnimation[] animations;
    
    private int animation_speed = 10;
    
    private final Vector2[] headings = {
            new Vector2(0, -1),     // top
            new Vector2(0, 1),      // down
            new Vector2(-1, 0),     // left
            new Vector2(1, 0),      // right
            new Vector2(-1, -1),    // top-left
            new Vector2(1, -1),     // top-right
            new Vector2(-1, 1),     // down-left
            new Vector2(1, 1),      // down-right
            new Vector2(0,0),       // zero
    };
    private boolean isMovingDiag(){
        return (dirs[0] && dirs[2]) || dirs[0] && dirs[3] || (dirs[1] && dirs[2]) || (dirs[1] && dirs[3]);
    }
    private boolean[] dirs={
        false,false,false,false
    };
    
    private float speed = 1.8f;
    private SpriteAnimation[] cats={
            new SpriteAnimation(new Spritesheet(Resources.white_cat,0,1,3,1,32,32).GetSprites()),
            new SpriteAnimation(new Spritesheet(Resources.white_cat,0,2,3,1,32,32).GetSprites()),
            new SpriteAnimation(new Spritesheet(Resources.white_cat,0,3,3,1,32,32).GetSprites()),
            new SpriteAnimation(new Spritesheet(Resources.white_cat,0,0,3,1,32,32).GetSprites()),
    };
    private SpriteAnimation[] actual;
    public Player(String _name, Spritesheet _sprite, int _x, int _y, int _width, int _height){
        super(_name, new Sprite(_sprite.GetSprite(1,0)), _x, _y, _width, _height);
        animations = new SpriteAnimation[]{
                new SpriteAnimation(new Spritesheet(_sprite,0,0,3,1,64,59).GetSprites()),
                new SpriteAnimation(new Spritesheet(_sprite,2,0,3,1,64,59).GetSprites()),
                new SpriteAnimation(new Spritesheet(_sprite,3,0,3,1,64,59).GetSprites()),
                new SpriteAnimation(new Spritesheet(_sprite,1,0,3,1,64,59).GetSprites()),
        };
        actual = animations;
        
    }
    
    private boolean isMoving(){
      return dirs[0] || dirs[1] || dirs[2] || dirs[3];
    }
    
    public void ChangeDir(int new_dir){
   
        dir = new_dir;
        
    }
    
    
    public void Tick(){
        counter++;
            if(dir <= 3)
                super.sprite = actual[dir];
            Vector2 heading = new Vector2();
            for(int i = 0; i < dirs.length;i++){
                if(dirs[i]){ heading.add(headings[i]);  }
            }
            super.position = Vector2.add(Vector2.mult(heading,isMovingDiag()?speed*.77f:speed),position);
        if(counter%animation_speed==0){
            if(!isMoving()){
                actual[dir].SetPosition(1);
                
            }else{
                actual[dir].Step();
            }
        }
            
    }
    
    @Override
    public void keyTyped(KeyEvent e){
    
    }

    @Override
    public void keyPressed(KeyEvent e){
        int kc = e.getKeyCode();
        dirs[0] = dirs[0] || kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W;
        dirs[1] = dirs[1] || kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S;
        dirs[2] = dirs[2] || kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A;
        dirs[3] = dirs[3] || kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D;

        for(int i = 0; i<4; i++){
            if(dirs[i]) ChangeDir(i);
        }
        if(e.getKeyCode() == VK_F3){
            super.sprite = cats[dir];
            actual = cats;
        }
        if(e.getKeyCode() == VK_F4){
            actual = animations;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int kc = e.getKeyCode();
         dirs[0] = !(!dirs[0] || kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W);
         dirs[1] = !(!dirs[1] || kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S);
         dirs[2] = !(!dirs[2] || kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A);
         dirs[3] = !(!dirs[3] || kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D);
    }
    

    
}
