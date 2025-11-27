/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author konda_957835
 */
public class APIAuthenticator extends Authenticator{
    private static final String AUTHORIZATION_KEY = "722326f68886ee262834a5b1280b0e26"; 
    private static final String USERNAME = "722326f68886ee262834a5b1280b0e26";
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, AUTHORIZATION_KEY.toCharArray());
    }
}
