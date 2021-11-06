package com.example.mylittledoctor;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name="items")
public class items {

    @Element
    public List<item> item;
}