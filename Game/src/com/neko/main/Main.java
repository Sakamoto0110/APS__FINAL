package com.neko.main;

import com.neko.utils.CircularArray;

public class Main{
    
    public static void main(String[] args) {
        IApplication app = Application.GetInstance();
        app.Initialize(720,720,"Pie");
        app.Start();
        
        
    }
    
}
