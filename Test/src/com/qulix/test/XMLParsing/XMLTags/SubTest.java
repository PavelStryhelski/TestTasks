package com.qulix.test.XMLParsing.XMLTags;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class SubTest {

    private String name;
    private final ArrayList<Block> blocks = new ArrayList<Block>();

    public String getName() {
        return name;
    }
    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name ="blocks")
    public ArrayList<Block> getBlockCollection() {
        return blocks;
    }

    public void addBlock(Block block) {
           blocks.add(block);
    }
    @XmlElement(name = "block")
    public Block createNewBlock() {

        return new Block(this);
    }

    public String toString(){
        return name;
    }
}
