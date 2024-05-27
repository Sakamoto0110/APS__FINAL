package com.neko.main;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.util.EventListener;

public interface IApplication {

    public void Initialize(int width, int height, String title);
    public void Start();
    public void Stop();
    public Dimension GetScreenBounds();

    
    
}
