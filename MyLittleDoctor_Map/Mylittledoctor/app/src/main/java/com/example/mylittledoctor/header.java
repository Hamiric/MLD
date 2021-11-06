package com.example.mylittledoctor;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name="header")
public class header {

    @PropertyElement
    public int resultCode;

    @PropertyElement
    public String resultMsg;
}

