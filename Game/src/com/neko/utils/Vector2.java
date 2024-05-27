package com.neko.utils;

public class Vector2{
    
    public float x,y;
    
    public Vector2() {
        this.x = 0;
        this.y = 0;
    }
    
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void add(Vector2 v) {
        this.x += v.x;
        this.y += v.y;
    }
    
    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }
    
    public void sub(Vector2 v) {
        this.x -= v.x;
        this.y -= v.y;
    }
    
    public static Vector2 sub(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }
    
    public void mult(double n) {
        this.x *= n;
        this.y *= n;
    }
    
    public static Vector2 mult(Vector2 a, float n) {
        return new Vector2(a.x * n, a.y * n);
    }
    
    public void div(double n) {
        this.x /= n;
        this.y /= n;
    }
    
    public static Vector2 div(Vector2 a, float n) {
        return new Vector2(a.x / n, a.y / n);
    }
    
    public float dot(Vector2 a) {
        return (this.x * a.x) + (this.y * a.y);
    }
    
    public static float dot(Vector2 a, Vector2 b) {
        return (a.x * b.x) + (a.y * b.y);
    }
    
    public static float angleBetween(Vector2 a, Vector2 b) {
        return (float) (Math.acos(dot(a, b) / (a.mag() * b.mag())));
    }
    
    public Vector2 copy() {
        return new Vector2(this.x, this.y);
    }
    
    public double mag() {
        return Math.sqrt((double) ((this.x * this.x) + (this.y * this.y)));
    }
    
    public void normalize() {
        this.div((float) this.mag());
    }
    
    public void limit(float n) {
        double mag = this.mag();
        if (mag > n && mag != 0) {
            double r = n / mag;
            this.x *= r;
            this.y *= r;
        }
        
    }
    
}