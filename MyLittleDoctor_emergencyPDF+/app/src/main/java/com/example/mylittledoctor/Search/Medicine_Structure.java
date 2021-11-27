package com.example.mylittledoctor.Search;

import java.io.Serializable;

public class Medicine_Structure implements Serializable {
    String Code;
    String Name;
    String Ingredients;
    String e;
    String Image;
    public Medicine_Structure(String Code,String Name,String Ingredients, String e, String Image){
        this.Code=Code;
        this.Name=Name;
        this.Ingredients=Ingredients;
        this.e=e;
        this.Image=Image;
    }
    public Medicine_Structure(String Code,String Name,String Ingredients, String e){
        this.Code=Code;
        this.Name=Name;
        this.Ingredients=Ingredients;
        this.e=e;
    }

}