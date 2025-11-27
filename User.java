/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

import java.util.ArrayList;

/**
 *
 * @author konda_957835
 */
public class User 
{
    private ArrayList<Memorizing_Goal> goals;
    private int tasksInStreak;
    private int streak;
    private boolean complete;

    public User() {
        goals = new ArrayList<Memorizing_Goal>();
        tasksInStreak = 0;
        streak = 0;
        complete = false;
    }
    
    //adds a new goal to the arraylist that stores all the users goals
    public void add_Goal(Memorizing_Goal newGoal)
    {
        goals.add(newGoal);
    }
    
    //alters the goal that has just been added
    public void change_Goal(Memorizing_Goal newGoal)
    {
        goals.add(goals.size() - 1, newGoal);
    }
    
    public Memorizing_Goal get_Goal(int index)
    {
        return goals.get(index);
    }
    
    public void removeGoal(int index)
    {
        goals.remove(index);
    }
        
}
