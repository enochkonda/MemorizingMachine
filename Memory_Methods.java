/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 *This is a specific memorizing method which will inherit from the Memorizing_Method class. 
 * It has its own special instance variables which are relevant for the decision process of which words should be removed from the text first. 
 * In the constructor, the text from the daily task will be subdivided into an String array where each index holds a word. This array will be sorted in the constructor. 
 * Note:
 * This class will be used for the writing text over an overlay and for the drag and drop learning methods because they both rely on removing words in the order of easiest to remember.
 * @author konda_957835
 */
public class Memory_Methods extends Memorizing_Method 
{
    ArrayList<String> words; //This the words in the text variable as seperate elements, these arraylist will always keep the words in the order of the original text
                             //as time goes on, indexes holding words in this arraylist will be replaced with blanks
    Stack<String> wordsToRemove; //This will store the words that are remaining to be removed from the                                                                
                                 //text overlay and the order that they come out of the stack are the order                                                 
                                 //that the remaining words should be removed
    int currWord;
    int currIndex;
    String[] originalWords;  //This is the original text having one word per index and will not be changed
    public Memory_Methods(String text, boolean optional) 
    {
        super(text, optional);
        words = new ArrayList<String>();
        wordsToRemove = new Stack<String>();
        originalWords = text.split(" ");
        for(int i = 0; i < originalWords.length; i++)
        {
            words.add(originalWords[i]);
        }
        //should be sorted hardest words to remember to easiest, tmp is a copy of the words in original words which will be sorts
        String[] tmp = new String[originalWords.length];
        for(int i = 0; i < originalWords.length; i++)
        {
            tmp[i] = originalWords[i];
        }
     
        Arrays.sort(tmp, Comparator.comparingInt(String::length));
      
        for (int i = 0; i < tmp.length; i++)
        {
            wordsToRemove.push(tmp[i]);
        }
    }
    
    public void remove(int amt)
    {
        for(int i = 0; i < amt; i++)
        {
            if(wordsToRemove.empty())
            {
                break;
            }
            String currWord = wordsToRemove.pop();
       
            int rmIndex = words.indexOf(currWord);
            String replacement = "";
            //makes the blank be the size of the word
            for(int blankSz = 0; blankSz < currWord.length(); blankSz++)
            {
                replacement += "_";            
            }
            //replaces the word with the blank
            words.remove(rmIndex);
            words.add(rmIndex, replacement);
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public Stack<String> getWordsToRemove() {
        return wordsToRemove;
    }
    
    public int wordsLeftToRemove()
    {
        return wordsToRemove.size();
    }

    public void setWordsToRemove(Stack<String> wordsToRemove) {
        this.wordsToRemove = wordsToRemove;
    }
}
