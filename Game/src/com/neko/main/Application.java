package com.neko.main;

import com.neko.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.EventListener;

public class Application extends Canvas implements IApplication, Runnable{
    private static Application app;
    
    private Thread thread;
    private JFrame frame;
    private BufferedImage background;
    private boolean isRunning;
    
    private Game game;
    
    
    @Override
    public void Initialize(int width, int height, String title){
        this.setPreferredSize(new Dimension(width, height));
        this.frame = new JFrame(title);
        
        this.frame.add(this);this.frame.pack();
        
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        
        this.frame.setVisible(true);
        this.background = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        game = new Game();
        this.addKeyListener(game.player);
    }
    
    public static IApplication GetInstance(){
        if(app == null){
            app = new Application();
        }
        return app;
    }
    
    private Application(){
    
    }
    
    
    
    
    @Override
    public void Start(){
        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }
    
    @Override
    public void Stop(){
        
        try{
            this.thread.join();
            this.isRunning = false;
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        
    }
    
    @Override
    public Dimension GetScreenBounds(){
        return this.frame.getSize();
    }
    
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while(isRunning)
        {
            long now = System.nanoTime();
            delta+= (now-lastTime) / ns;
            lastTime = now;
            if ( delta >= 1 )
            {
                this.Tick();
                this.Render();
                frames++;
                delta--;
            }
            if ( System.currentTimeMillis()-timer >= 1000)
            {
                System.out.println("FPS: "+frames);
                frames = 0;
                timer+= 1000;;
            }
        }
        this.Stop();
    }
    
    private void Tick(){
        game.Tick();
    }
    
    private void Render(){
        BufferStrategy bs = getBufferStrategy();
        if ( bs == null ) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = background.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(14,14,14));
        g.fillRect(0, 0, getWidth(), getHeight());
        // **
        game.Render(g);
        
        // **
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(background, 0, 0, getWidth(), getHeight(),null);
        bs.show();
    }
    
 }
