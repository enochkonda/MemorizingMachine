/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

/**
 *
 * @author konda_957835
 */
public class TextOverlay extends Memory_Methods{
    
    int currWord; //indice of the word in the original array
    int currIndex; //indice of the current char in the word
    int correctChars; //how many chars the user typed correctly
    boolean space;
    String currentText;
    String completedText;
    
    public TextOverlay(String text) {
        super(text, false);
        currWord = 0;
        currIndex = 0;
        correctChars = 0;   //how many chars the user haas typed correctly so far
        space = false;  //whether the user needs to type a space
        
        currentText = "";
        completedText = "";

        //turns what is in the arrays back to text form (for the original piece of text to memorize and for the uncompletedText)
        //the uncompleted text is the text with blanks
        for(int i = 0; i < this.words.size(); i++)
        {
            currentText += this.words.get(i) + " ";
        }
        currentText = currentText.substring(0, currentText.length() - 1);
        
        //the completed text is only created once because the completed text will always be the same, however uncompleted text is changed every time words are removed
        for(int i = 0; i < this.words.size(); i++)
        {
            completedText += this.words.get(i) + " ";
        }
        completedText = completedText.substring(0, completedText.length() - 1);
      
    }
    
    public void reset()
    {
        currWord = 0;
        currIndex = 0;
        correctChars = 0;   //how many chars the user haas typed correctly so far
        space = false;  //whether the user needs to type a space
        
        currentText = "";

        //turns what is in the arrays (with blanks) back to text form 
        //the uncompleted text is the text with blanks
        for(int i = 0; i < this.words.size(); i++)
        {
            currentText += this.words.get(i) + " ";
        }
        currentText = currentText.substring(0, currentText.length() - 1);
    }

    public void incWord()
    {
        if(currWord < this.originalWords.length)
            currWord++;
    }
    
    //if the index of the end of the word is reached, this method will call the incWord method
    public void incIndex()
    {
        //ensure this isn't out of bounds, coorect chars include spaces since completed/uncompleted portions include spaces
        correctChars++;
        //the next char to be typed shoulud be the next letter in the word if the current index is not the last index in the word
        if(currIndex < this.originalWords[currWord].length() - 1)
        {
            currIndex++;
        }
        //otherwise, the next char to be typed is the first index in the next word
        else
        {
            //space is set to true because the user must type a space between these two words
            space = true;
            currIndex = 0;
            this.incWord();
        }
    }
    
    public void incCorrectChars()
    {
        correctChars++;
    }
    
    public int getCurrWord() {
        return currWord;
    }

    public void setCurrWord(int currWord) {
        this.currWord = currWord;
    }

    public int getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(int currIndex) {
        this.currIndex = currIndex;
    }
    
    public void setSpace(boolean space)
    {
        this.space = space;
    }
    
    public char getCurrChar()
    {
        if(space)
        {
            return ' ';
        } 
        return originalWords[this.getCurrWord()].charAt(this.getCurrIndex());
    }
    
    public boolean doneTyping()
    {
        return (correctChars == currentText.length());
    }
    
    public String getCompeltedPortion()
    {
        if(correctChars <= completedText.length())
        {
            return completedText.substring(0, correctChars);
        }
        return "BUG";
    }
    
    public String getUncompletedPortion()
    {
        if(correctChars <= currentText.length())
        {
            return currentText.substring(correctChars);
        }
        return "BUG";
    }
    
    /*public String getOriginalPortionText()
    {
        String output = "";
        //adds all the words up to the last word in the selection of words to add to the string
        for(int i = 0; i < currWord; i++)
        {
            output += this.originalWords[i] + " ";
        }
        output += this.originalWords[currWord].substring(0, currIndex + 1);
        return output;
    }
    
    public String getUntypedPortionText()
    {
        String output = "";
        if(currIndex < this.originalWords[currWord].length())
        {
            output += this.originalWords[currWord].substring(currIndex);
        }
        
        for(int i = currWord + 1; i < this.originalWords.length; i++)
        {
            output += this.originalWords[i] + " ";
        }
        return output.substring(0, output.length() - 1);
    }*/
    
    
    
}
