package com.neko.game;

import com.neko.graphics.ISprite;
import com.neko.utils.Vector2;

import java.awt.*;

public class GameObject implements IGameObject {
    
    protected Vector2 position;
    protected Vector2 velocity;
    protected String name;
    protected ISprite sprite;
    protected int width;
    protected int height;
    protected boolean is_dead =false;
    protected float scale = 1;
    
    
    public GameObject(String _name, ISprite _sprite, int _x, int _y, int _width, int _height) {
        position = new Vector2(_x, _y);
        name = _name;
        sprite = _sprite;
        width = _width;
        height = _height;
        velocity = new Vector2(0,0);
    }
    
    public void Respawn(ISprite _sprite, int x, int y) {
        sprite = _sprite;
        position = new Vector2(x, y);
    }
    
    @Override
    public String GetName(){
        return name;
    }
    
    @Override
    public Vector2 GetPosition(){
        return position;
    }
    
    @Override
    public Vector2 GetSize(){
        return new Vector2(width*scale, height*scale);
    }
    
    @Override
    public Rectangle GetBounds(){
        return new Rectangle((int) position.x, (int) position.y, (int) (width*scale), (int) (height*scale));
    }
    
    @Override
    public void Render(Graphics g){
        if(!is_dead){
            float ww = width * scale;
            float hh = height * scale;
            g.drawImage(sprite.GetImage(), (int) position.x, (int) position.y, (int)ww,(int)hh,null);
            
        }
    }
}
