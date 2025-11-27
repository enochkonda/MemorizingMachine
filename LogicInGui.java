  private void confirmGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmGoalActionPerformed

        if(selectGoal.getItemCount() == 0)
        {
            noGoalsWarning.setText("You must create a memorizing goal first, click \"New Goal\"");
            return;
        }
        homePage.setVisible(false);
        CreateMemoryGoalPanel.setVisible(false);
        int goalIndex = selectGoal.getSelectedIndex();
        //gets the goal from the goal index in the users arraylist of goals and then gets the text to memorize from that goal
        currGoal = user.get_Goal(goalIndex);
        currGoal.setDropdownIndex(goalIndex);
        String memorizeText = user.get_Goal(goalIndex).nextTask().getText();
        MemorizeText.setText("");
        doc = MemorizeText.getStyledDocument();
        SimpleAttributeSet uncompletedFont = new SimpleAttributeSet();
        StyleConstants.setForeground(uncompletedFont, Color.GRAY);
        try {
            //this makes the doc hold the text before the user begins typing
            doc.insertString(doc.getLength(), memorizeText, uncompletedFont);
        } catch (BadLocationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        currOverlay = new TextOverlay(memorizeText);
     
  
        TextOverlayTask.setVisible(true);
    }//GEN-LAST:event_confirmGoalActionPerformed

    private void newGoalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGoalMouseClicked
        // TODO add your handling code here:
        homePage.setVisible(true);
        TextOverlayTask.setVisible(false);
        createMemoryGoal_.setVisible(true);
    }//GEN-LAST:event_newGoalMouseClicked

    private void MemorizeTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MemorizeTextKeyPressed
        //if the user has already finished the challenge, the cannot type anymore
        //shouldn't just test if done typing, done typing means just typed one way thorugh
        if(currOverlay.doneTyping() && currOverlay.wordsLeftToRemove() == 0)
        {
          
            // all of the owrds must be turned into blanks
            return;
           
        }
        char charTyped = evt.getKeyChar();
        //if the key the user types is not the expected char, exit the function
        if (currOverlay.getCurrChar() != charTyped)
        {
            return;
        }
       
        //this if statement means that if the expected char was a ' ' and the user entered it (because of the if statement above)
        if(currOverlay.getCurrChar() == ' ')
        {
            //then the next char cannot be a space
            currOverlay.setSpace(false);
            //a space counts as a correctChar - because completed/uncompleted portions include spaces - so the number of correctChars must be incremented
            currOverlay.incCorrectChars();
        }
        else
        {
            //if the char we are on is a space, we don't want to increment the index, since this applies to the index of the current word
            //and spaces are not in words, hence, we increment the index in this else statement
            //the index will only be incremented if the user types the expected char and that expected char is NOT a space
            currOverlay.incIndex();       
        }
        
        try
        {
            SimpleAttributeSet completedFont = new SimpleAttributeSet();
            StyleConstants.setForeground(completedFont, new Color(0, 208, 14));
            StyleConstants.setBold(completedFont, true);
            
            SimpleAttributeSet cursorFont = new SimpleAttributeSet();
            StyleConstants.setForeground(cursorFont, new Color(21, 98, 207));
            
            
            //sets the Memorize text to blank so a blank document can be acquired
            MemorizeText.setText("");
            doc = MemorizeText.getStyledDocument();
            //doc length is 0, it first inserts the completed poriton 
            doc.insertString(doc.getLength(), currOverlay.getCompeltedPortion(), completedFont);
            //by inserting at doLength, we insert the uncompleted portion right after the completed portion
            SimpleAttributeSet uncompletedFont = new SimpleAttributeSet();
            StyleConstants.setForeground(uncompletedFont, Color.GRAY);
            doc.insertString(doc.getLength(), "|", cursorFont);
            doc.insertString(doc.getLength(), currOverlay.getUncompletedPortion(), uncompletedFont);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        //when the user has finished typing
        if(currOverlay.doneTyping())
        {
            if(currOverlay.wordsLeftToRemove() == 0)
            {
                System.out.println("tasksLeft: " + currGoal.tasksLeft());
                SimpleAttributeSet feedbackFont = new SimpleAttributeSet();
                StyleConstants.setForeground(feedbackFont, new Color(0, 0, 200));
                MemorizeText.setText("");
                doc = MemorizeText.getStyledDocument();
                try {
                    if(currGoal.tasksLeft() == 0)
                    {
                         doc.insertString(doc.getLength(), "Congragulations, you have completed the entire memorizing goal. Your memorizing goal will now be removed from your dashboard's drop down list. Please press \"Dashboard\" on the menu above.", feedbackFont);
                         selectGoal.removeItemAt(currGoal.getDropdownIndex());
                         user.removeGoal(currGoal.getDropdownIndex());
                         if(selectGoal.getItemCount() == 0)
                         {
                             noGoalsWarning.setText("You have no memorizing goals, click \"New Goal\"");
                         }
                    }
                    else
                    {
                        doc.insertString(doc.getLength(), "Congragulations, you have completed the task, please press \"Dashboard\" on the menu above", feedbackFont);
                    }
                } catch (BadLocationException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                currOverlay.remove(2);
                //the reset method is called so that the text shows the blanks
                currOverlay.reset();
                MemorizeText.setText("");
                doc = MemorizeText.getStyledDocument();
                SimpleAttributeSet uncompletedFont = new SimpleAttributeSet();
                StyleConstants.setForeground(uncompletedFont, Color.GRAY);
                try {
                    //the doc now shows the text with blanks
                    doc.insertString(doc.getLength(), currOverlay.getUncompletedPortion(), uncompletedFont);
                } catch (BadLocationException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }//GEN-LAST:event_MemorizeTextKeyPressed

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked

        homePage.setVisible(true);
        TextOverlayTask.setVisible(false);
        createMemoryGoal_.setVisible(false);
        MemorizeText.setText("");
    }//GEN-LAST:event_dashboardMouseClicked
//the next button is located on the first page of creating a new memorizing goal
    private void next_JButton_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_JButton_MouseClicked
        // TODO add your handling code here:
        createMemoryGoal_.setVisible(false);
        goalConfirm.setVisible(true);
        tmpGoal.setText(plainTextBox.getText());
        //clears the text box after text has been extracted
        plainTextBox.setText("");
        GoalNamejTextField.setText("");
        numDaysJTextField.setText("1");
    }//GEN-LAST:event_next_JButton_MouseClicked

    private void create_jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_jButtonMouseClicked
        // TODO add your handling code here:
        //can find a better way to update this, the warning about having no memorizing goals should be gone the FIRST time a goal is added, this does it everytime a goal is added
        noGoalsWarning.setText("");
        goalConfirm.setVisible(false);
        //this should be made fool proof (if users don't type in numbers
        tmpGoal.setDays(Integer.parseInt(numDaysJTextField.getText()));
        tmpGoal.setName(GoalNamejTextField.getText());
        //adds the new goal
        user.add_Goal(tmpGoal);
        tmpGoal = new Memorizing_Goal();
        //after a new goal is created, it is addded to the available goals that can be selected
        selectGoal.addItem(GoalNamejTextField.getText());
    }//GEN-LAST:event_create_jButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                   
                } catch (BadLocationException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
