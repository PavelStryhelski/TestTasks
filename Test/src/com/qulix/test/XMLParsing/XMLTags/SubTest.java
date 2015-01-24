package com.qulix.test.XMLParsing.XMLTags;

import java.util.ArrayList;

public class SubTest {

    private String name;
    private final ArrayList<Block> blocks = new ArrayList<Block>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Block> getBlockCollection() {
        return blocks;
    }

    public void addBlock(Block block) {
           blocks.add(block);
    }

    public Block createNewBlock() {

        return new Block(this);
    }

    public String toString(){
        return name;
    }
}
