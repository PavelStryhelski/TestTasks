package com.qulix.test.XMLParsing.XMLTags;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class Elem
{
    private String name;
    private ArrayList<Param> params = new ArrayList<Param>();
    private final Block block;

    public Elem(Block owner){
        this.block = owner;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name  = "name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "param")
    public ArrayList<Param> getParamCollection() {
        return params;
    }

    public void addParam(Param param) {
        params.add(param);
    }

    public Param createNewParam() {
        return new Param(this);
    }

    public String toString(){
        return name;
    }
}
