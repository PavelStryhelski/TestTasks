package com.qulix.test.XMLParsing.XMLTags;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;

public class Block
{
    private String name;
    private final ArrayList<Elem> elems = new ArrayList<>();
    private final SubTest subTest;

    public Block(SubTest owner){
        this.subTest = owner;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name ="elements")
    @XmlElement(name = "element")
    public ArrayList<Elem> getElemCollection() {
        return elems;
    }

    public void addElement(Elem elem){
        elems.add(elem);
    }

    public Elem createNewElem() {

        return new Elem(this);
    }

    public String toString(){
        return name;
    }
}