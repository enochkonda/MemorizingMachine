/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author konda_957835
 */
public class GraphicsPanel extends JPanel implements Serializable {
    
    public void generateGraph()
    {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        
    }
    
      
    
}

