/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bibliotecafamiliar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

import java.io.File;
import java.net.URISyntaxException;


/**
 *
 * @author faust
 */
public class BibliotecaFamiliar {

    public static void main(String[] args) {

    
        String filePath = "C:\\Users\\faust\\Desktop\\Java\\family-book-manager\\bibliotecaFamiliar\\target\\classes\\com\\mycompany\\bibliotecafamiliar\\libros.json";

        JSONFileManager jsonFileManager = new JSONFileManager();
        List<JSONObject> jsonList = jsonFileManager.readListOfJsonsFromFile(filePath);

        String first=jsonList.get(0).toJSONString();
        System.out.println(first);

        /* 
        // Display the content of the JSON list
        for (JSONObject json : jsonList) {
            System.out.println(json.toJSONString());
        }
        */
    
    }
    
   
    
}