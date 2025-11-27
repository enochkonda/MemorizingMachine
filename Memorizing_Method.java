/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

/**
 * The Memorizing Goal Class will contain the portion of text the user wants to memorize and how many days the user wants to memorize that day in. 
 * It will also contain an arrayList and a queue of daily tasks. In the constructor of the Memorizing_Goal Class, 
 * the text will be divided into x groups where x is the number of days the user has to complete the goal. 
 * Each one of these groups of text will be used to create a Daily_Task.
 * @author konda_957835
 */
public class Memorizing_Method 
{
    String text;    //text that this task has given to this method to memorize
    boolean completed;  //whether this method has been completed (it will be part of a task)
    boolean optional;   //true if the memorizing method is textOverlay, false if it is the other two memorizing methods

    public Memorizing_Method(String text, boolean optional) {
        this.text = text;
        this.optional = optional;
        completed = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
    
}
