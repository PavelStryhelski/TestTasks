package com.qulix.test.XMLParsing.XMLTags;

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

    public void setName(String name) {
        this.name = name;
    }

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