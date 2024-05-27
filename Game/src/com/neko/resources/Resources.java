package com.neko.resources;

import com.neko.graphics.Sprite;
import com.neko.graphics.Spritesheet;

public class Resources{
    
    
    private static Spritesheet _humans = new Spritesheet("res/humans.png",64,59);
    
    public static Spritesheet humans[] = {
            new Spritesheet(_humans,0,0,12,1,64,59),
            new Spritesheet(_humans,0,1,12,1,64,59),
            new Spritesheet(_humans,0,2,12,1,64,59),
            new Spritesheet(_humans,0,3,12,1,64,59),
            new Spritesheet(_humans,0,4,12,1,64,59),
            new Spritesheet(_humans,0,5,12,1,64,59),
            new Spritesheet(_humans,0,6,12,1,64,59),
            new Spritesheet(_humans,0,7,12,1,64,59),
    };
    public static Spritesheet tiles = new Spritesheet("res/ground_sprites.png",16,16);
    
    public static Sprite[] grass_tiles = {
            new Sprite(5,3,tiles),
            new Sprite(5,4,tiles),
            new Sprite(6,4,tiles),
            
            new Sprite(4,8,tiles),
            new Sprite(5,8,tiles),
            new Sprite(6,8,tiles),
            new Sprite(4,8,tiles),
            new Sprite(5,8,tiles),
            new Sprite(6,8,tiles),
            
    };
    
    public static Spritesheet slime_idle = new Spritesheet("res/slime_idle.png",32,32);
    public static Spritesheet slime_die = new Spritesheet("res/slime_die.png",32,32);
    
    
    private static Spritesheet cats = new Spritesheet("res/cat.png",32,32);
    public static Spritesheet white_cat = new Spritesheet(cats,0,0,3,4,32,32);
    public static Spritesheet yellow_cat = new Spritesheet(cats,1,0,3,4,32,32);
    public static Spritesheet brown_cat = new Spritesheet(cats,2,0,3,4,32,32);
    public static Spritesheet black_cat = new Spritesheet(cats,3,0,3,4,32,32);
    
}
