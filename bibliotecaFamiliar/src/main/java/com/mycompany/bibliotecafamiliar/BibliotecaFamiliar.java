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
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


/**
 *
 * @author faust
 */
public class BibliotecaFamiliar {

    public static void main(String[] args) throws IOException, ParseException {

        String testFilePath = "test.json";
        JSONFileManager jsonFileManager = new JSONFileManager();
        List<JSONObject> jsonListEdith = jsonFileManager.getJsonObjectsWithKey("Genero","Cuento",testFilePath);
        System.out.println(jsonListEdith);
        
 
    }
  
}