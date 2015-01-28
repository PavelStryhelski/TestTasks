package com.qulix.test.XMLParsing.SAXParser;


import com.qulix.test.XMLParsing.XMLTags.Block;
import com.qulix.test.XMLParsing.XMLTags.Elem;
import com.qulix.test.XMLParsing.XMLTags.Param;
import com.qulix.test.XMLParsing.XMLTags.SubTest;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Handler extends DefaultHandler{

    private ArrayList<SubTest> subTests;
    private SubTest test;
    private Block block;
    private Elem elem;
    private Param param;

    public ArrayList<SubTest> getSubTests() {
        return subTests;
    }

    @Override
    public void startDocument() throws SAXException
    {
        subTests = new ArrayList<SubTest>();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs){

        if (qName.equals("test")){
            test = new SubTest();
            test.setName(attrs.getValue(0));
        }

        if (qName.equals("block")){
            block = new Block(test);
            block.setName(attrs.getValue(0));
        }

        if (qName.equals("element")){
            elem = new Elem(block);
            elem.setName(attrs.getValue(0));
        }

        if (qName.equals("param")){

            param = new Param(elem);
            param.setName(attrs.getValue(0));

            if (attrs.getLength() == 2){
               param.setValue(attrs.getValue(1));
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName){

        if (qName.equals("test")){
            subTests.add(test);
        }

        if (qName.equals("block")){
            test.addBlock(block);
        }

        if (qName.equals("element")){
            block.addElement(elem);
        }

        if (qName.equals("param")){
            elem.addParam(param);
        }

    }

    @Override
    public void endDocument() throws SAXException{}

}
