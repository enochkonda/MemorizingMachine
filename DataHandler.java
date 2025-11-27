/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csiii.memorizingmachine;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author konda_957835
 */
public class DataHandler {
    //private static final String AUTHORIZATION_KEY = "de4e12af7f28f599-01"; 
    //private static final String USERNAME = "";
    //private static final String SERVER = "api.scripture.api.bible";
    //private static final String AUTHORIZATION_STRING = USERNAME + ":" + AUTHORIZATION_KEY;
    //private static final String BASE64ENCODED = "";


    
    
    
    public String getJSONString(String apiEndPoint)
    {
        try 
        {
            HttpClient client = HttpClient.newBuilder().authenticator(new APIAuthenticator()).build();
            HttpRequest request = HttpRequest.newBuilder().GET().uri(new URI("https://api.scripture.api.bible/v1/bibles/de4e12af7f28f599-01/books" + apiEndPoint)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            return response.body();
        } catch (URISyntaxException | InterruptedException | IOException ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
}
