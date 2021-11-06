package com.example.mylittledoctor;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class LocationResult {

    @Element
    public header header;

    @Element
    public body body;
}
