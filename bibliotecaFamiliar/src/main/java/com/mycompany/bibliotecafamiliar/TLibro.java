package com.mycompany.bibliotecafamiliar;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.*;

public class TLibro implements ILibro {

    private String Title;
    private String Author;
    private String Genre;
    private String Owner=null; 
    private boolean Estate=false;  
    private int Code;  

/* 
    public TLibro(String title, String author, String genre){
        this.Title=title;
        this.Authors.add(author);
        this.Genre=genre;
    }
*/
public TLibro(String title, String author, String genre,String owner, boolean estate, int code){
        this.Title=title;
        this.Author=author;
        this.Genre=genre;
        this.Owner=owner;
        this.Estate=estate;
        this.Code=code;
    }


    @Override
    public void setTitle(String title){
        this.Title=title;
    }

    @Override
    public void addAuthor(String author){
        this.Author=this.Author+" & "+author;
    }

    public void setAuthor(String author){
        this.Author=author;
    }

    
    

    @Override
    public void setGenre(String genre){
        this.Genre=genre;
    }

    public void setOwner(String owner){
        this.Owner=owner;
    }

    public String getTitle(){
        return this.Title;
    }

    public String getOwner(){
        return this.Owner;
    }
    public void changeEstate(){
        if(this.Estate==false){
            this.Estate=true;
        }else{
            this.Estate=false;
        }
    }

    public String getGenre(){
        return this.Genre;
    }
    public int getCode(){
        return this.Code;
    }

    public String getAuthorList(){

        return this.Author;
    }
    public JSONObject getJson(){
        JSONObject content=new JSONObject();
        
        
        if(this.Estate==false){
            content.put("Prestado", "False");
        }else{
            content.put("Prestado", "True");
        }
        content.put("Propietario", this.Owner);
        content.put("Genero", this.Genre);
        content.put("Autor", this.Author);
        content.put("Titulo", this.Title);
        content.put("Codigo", this.Code);

        return content;
    }
    
}
