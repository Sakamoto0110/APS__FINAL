package com.neko.game;

import com.neko.utils.Vector2;

import java.awt.*;

public interface IGameObject{
    
    public String GetName();
    public Vector2 GetPosition();
    public Vector2 GetSize();
    
    public Rectangle GetBounds();
    
    public void Render(Graphics g);
    
}
