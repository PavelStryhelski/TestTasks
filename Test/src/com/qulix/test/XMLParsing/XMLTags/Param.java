package com.qulix.test.XMLParsing.XMLTags;

public class Param{

    private String name;
    private String value;
    private final Elem elem;

    public Param(Elem owner){
        elem = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

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