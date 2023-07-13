package com.mycompany.bibliotecafamiliar;

import java.util.ArrayList;
import java.util.List;

public class TLibro implements ILibro {

    private String Title;
    private List<String> Authors = new ArrayList<String>();
    private String Genrer;
    private String Owner; 


    public TLibro(String title, String author, String genrer){
        this.Title=title;
        this.Authors.add(author);
        this.Genrer=genrer;
    }

    @Override
    public void setTitle(String title){
        this.Title=title;
    }

    @Override
    public void setAuthors(String author){
        this.Authors.add(author);
    }

    @Override
    public void setGenre(String genrer){
        this.Genrer=genrer;
    }

    
    
}
