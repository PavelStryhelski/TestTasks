package com.qulix.test.XMLParsing.XMLTags;

import javax.xml.bind.annotation.XmlAttribute;

public class Param {

    private String name;
    private String value;
    private final Elem elem;

    public Param(Elem owner){
        elem = owner;
    }

    public String getName() {
        return name;
    }
    
    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute(name = "value")
    public void setValue(String value) {
        this.value = value;
    }

    public Elem getElem() {
        return elem;
    }

    public String toString(){
        return name + " : " + value;
    }
}