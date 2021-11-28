package com.example.mylittledoctor.Calendar;

import java.io.Serializable;

public class list_Structure implements Serializable {
    String Code;
    String Name;
    String Ingredients;
    String e;
    String Image;
    public list_Structure(String Code,String Name,String Ingredients, String e, String Image){
        this.Code=Code;
        this.Name=Name;
        this.Ingredients=Ingredients;
        this.e=e;
        this.Image=Image;
    }
    public list_Structure(String Code,String Name,String Ingredients, String e){
        this.Code=Code;
        this.Name=Name;
        this.Ingredients=Ingredients;
        this.e=e;
    }

}