package com.neko.graphics;

import com.neko.utils.CircularArray;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteAnimation implements ISprite {

    public CircularArray<BufferedImage> sprites;
    
    public SpriteAnimation(ArrayList<BufferedImage> sprites) {
        BufferedImage[] imgs = new BufferedImage[sprites.size()];
        imgs = sprites.toArray(imgs);
       this.sprites = new CircularArray<>(sprites.toArray(imgs));
        
    }
    
    public BufferedImage SetPosition(int idx){ return sprites.SetPosition(idx); }
    
    public void Step(){sprites.Advance();}
    
    @Override
    public BufferedImage GetImage(){
        return sprites.Get_Actual();
    }
}
