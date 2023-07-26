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

    
        String filePath = "libros.json";
        String TestfilePath = "test.json";
        JSONFileManager jsonFileManager = new JSONFileManager();
        List<JSONObject> jsonList = jsonFileManager.readListOfJsonsFromFile(filePath);
        TLibro testBook=new TLibro("testName", "testAutor", "testGener","testOwner",false);
        JSONObject jsonBook=testBook.getJson();
        jsonFileManager.addJsonFile(jsonBook, TestfilePath);
       

        /* 
        String first=jsonList.get(1).toJSONString();
         System.out.println(first);
        // Display the content of the JSON list
        for (JSONObject json : jsonList) {
            System.out.println(json.toJSONString());
        }
        TLibro testBook=new TLibro("testName", "testAutor", "testGener");
        String title=testBook.getTitle();
        String author=testBook.getAuthorList().get(0);
        String genre=testBook.getGenre();
        System.out.println(title);
        System.out.println(author);
        System.out.println(genre);

        */
    
    }
    
   
    
}