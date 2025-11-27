/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

/**
 *
 * @author konda_957835
 */
public class Daily_Task 
{
    String text;
    Memorizing_Method[] methods;

    public Daily_Task(String text) {
        this.text = text;
        methods = new Memorizing_Method[3];
        methods[0] = new TextOverlay(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Memorizing_Method[] getMethods() {
        return methods;
    }

    public void setMethods(Memorizing_Method[] methods) {
        this.methods = methods;
    }
    
    
    
    
}
