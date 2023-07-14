package com.mycompany.bibliotecafamiliar;

import java.util.ArrayList;
import java.util.List;

public class TLibro implements ILibro {

    private String Title;
    private List<String> Authors = new ArrayList<String>();
    private String Genre;
    private String Owner=null; 


    public TLibro(String title, String author, String genre){
        this.Title=title;
        this.Authors.add(author);
        this.Genre=genre;
    }

    @Override
    public void setTitle(String title){
        this.Title=title;
    }

    @Override
    public void addAuthors(String author){
        this.Authors.add(author);
    }
    public void removeAuthor(String author){
        int location=this.Authors.indexOf(author);
        while(location>-1){
            this.Authors.remove(location);
            location=this.Authors.indexOf(author);
        }
         
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

    public String getGenre(){
        return this.Genre;
    }

    public List<String> getAuthorList(){

        return this.Authors;
    }
    
    
}
