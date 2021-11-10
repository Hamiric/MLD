package com.example.mylittledoctor;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name="body")
public class body {

    @Element
    public items items;

    @PropertyElement
    public int numOfRows;

    @PropertyElement
    public int pageNo;

    @PropertyElement
    public int totalCount;
}