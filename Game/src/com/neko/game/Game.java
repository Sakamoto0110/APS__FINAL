package com.neko.game;

import com.neko.graphics.Sprite;
import com.neko.graphics.SpriteAnimation;
import com.neko.graphics.Spritesheet;
import com.neko.main.Application;
import com.neko.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Random;

public class Game {
    
    
    private GameMap map;
    public Player player;
    
    public ArrayList<Prop> props = new ArrayList<>();
    
    public int score = 0;
    
    public Game(){
       
        props.add(new Prop("", new SpriteAnimation(Resources.slime_idle.GetSprites()),300,300,32,32));
        player = new Player(
                "player",
                Resources.humans[0],
                Application.GetInstance().GetScreenBounds().width/2,
                Application.GetInstance().GetScreenBounds().height/2,
                64,
                59
        );
        
        map = new GameMap(45,45);
    }
    int counter = 0;
    public void Tick(){
        Random rand = new Random();
            if(counter++%300 == 0 && props.size() < 25){
                
                
                props.add(new Prop("", new SpriteAnimation(Resources.slime_idle.GetSprites()),rand.nextInt(300)+200, rand.nextInt(300)+200,32,32));
                
            }else{
                for(Prop p : props){
                    if(p.is_dead){
                        p.Born(rand.nextInt(720), rand.nextInt(720));
                    }
                }
            }
            player.Tick();
            for(Prop p : props){
                if(!p.is_dead && !p.is_borning && p.GetBounds().intersects(player.GetBounds())){
                    if(!p.invencible){
                        
                        if(!p.is_dying){
                            score++;
                        }
                        p.Kill();
                    }
                }
                if(p.is_dead && !p.is_borning){
                    
                    if(rand.nextInt(0,1000) < 20){
                        System.out.printf("spawning\n");
                        p.Born(rand.nextInt(720), rand.nextInt(720));

                    }
                }
            }
            
            
    }
    
    public void Render(Graphics g){
       
        for(Tile t : map.tiles){
            t.Render(g);
        }
        for(Prop p : props){
            p.Render(g);
        }
        player.Render(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 48));
        g.drawString(String.valueOf(score),10,48);
    }
    
}
