package com.neko.graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteCollection implements ISprite{

    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private int position = 0;
    
    public SpriteCollection(ArrayList<BufferedImage> _sprites) {
        sprites.addAll(_sprites);
    }
    
    public void ChangeSprite(int new_pos){
        position = new_pos;
    }
    
    @Override
    public BufferedImage GetImage(){
        return sprites.get(position);
    }
}
