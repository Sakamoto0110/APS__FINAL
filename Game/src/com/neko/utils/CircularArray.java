package com.neko.utils;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Iterator;

public class CircularArray <T> implements Iterable<T> {
    
    private T[] data;
    private int pos;
    private final int size;
    
    @SuppressWarnings("unchecked")
    public CircularArray(int sz) {
        if(sz > 0)
            this.data = (T[]) new Object[sz];
        else throw new InvalidParameterException("array size must be greater than 0");
        this.size = sz;
    }
    
    public CircularArray(T[] data) {
        this.data = data;
        this.size = data.length;
    }
    
    public static <I> CircularArray<I> Merge(CircularArray<I> arr1, CircularArray<I> arr2) {
        CircularArray<I> arr = new CircularArray<>(arr1.size+arr2.size);
        for(int i = 0; i < arr1.size + arr2.size; i++)
            if(i < arr1.size)
                arr.data[i] = arr1.data[i];
            else
                arr.data[i] = arr2.data[i - arr1.size];
        return arr;
    }
    public void Go_Back(){ this.pos -= this.pos==0?0:1;}
    public void Advance(){this.pos++;}
    public T SetPosition(int pos) { this.pos = pos; return Get_Actual(); }
    public int GetSize() { return size; }
    public void Append(T data) { this.data[pos +1 == Integer.MAX_VALUE ? 0 : ++pos -1] = data;}
    public T Get(int idx){ return data[idx]; }
    public T Get_Actual(){ return data[pos %size]; }
    public T Get_Next(){ return data[pos +1 == Integer.MAX_VALUE ? 0 : pos++%size]; }
    public T Peek_Next() { return data[pos +1 == Integer.MAX_VALUE ? 0 : pos +1%size]; }
    
  
    
    
    
    @Override
    public Iterator<T> iterator(){
        return Arrays.stream(data).iterator();
    }
}
