/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author konda_957835
 */
public class Memorizing_Goal {
    private String text;
    private String name;
    private int days;
    private Queue<Daily_Task> tasks;
    private int dropdownIndex;
    
    public Memorizing_Goal() {
        text = "";
        name = "";
        days = 0;
        tasks = new LinkedList<>();
        dropdownIndex = -1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        String[] words = text.split(" ");
        //algorithm
        //turn text into a string array
        //loop over words array adding each word to a string until you get to a word with a period in it (.contains(".")
        //counts how many words
        int cnt = 0;
        String currTaskText = "";
        //make an option that does it based on the number of words the user wants to divide by
        //first sum how many words are there
        //then ceil(total words/ user days)
        //use a forloop while there are words left, and try to break each task into that amount of words
        //if()
        for(String currWord : words)
        {
            currTaskText += currWord + " ";
            cnt++;
           
            if((currWord.contains(".") && cnt > 2) || (cnt > 3))
            {
                tasks.add(new Daily_Task(currTaskText));
                currTaskText = "";
                cnt = 0;
            }
        }
        if(!currTaskText.equals(""))
        {  
            tasks.add(new Daily_Task(currTaskText));
        }
        
//then add that word with the period in it. If it is above 20 words stop and begin a new sentence.
        //then if you pass 30 words and you are on the same sentence, split the sentence
        
        
        //API ideas
        //you only allow users to select certain verses within a chapter
        //use https://api.scripture.api.bible/v1/bibles/de4e12af7f28f599-01/chapters/2CO.4/verses except for
        //"2CO.4" keep incrementing up until endVerse using a for loop so 2CO. + "i" in request i going from begginig verse to end verse
        //can use length of the data array to prevent user from picking a value to large and to edit the drop downs
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int tasksLeft() {
        return tasks.size();
    }

    public void setTasks(Queue<Daily_Task> tasks) {
        this.tasks = tasks;
    }
    
    public Daily_Task nextTask()
    {
        return tasks.poll();
    }

    public int getDropdownIndex() {
        return dropdownIndex;
    }

    public void setDropdownIndex(int dropdownIndex) {
        this.dropdownIndex = dropdownIndex;
    }
    
    
    
    
    
    
    
    
    
}
