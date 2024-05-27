package com.neko.graphics;

import java.awt.image.BufferedImage;

public class Sprite implements ISprite {

    private BufferedImage sprite;

    public Sprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
    public Sprite(int x, int y, Spritesheet src) {
        sprite = src.GetSprite(x,y);
        
    }
    
    @Override
    public BufferedImage GetImage(){
        return sprite;
    }
}
