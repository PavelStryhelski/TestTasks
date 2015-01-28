package com.qulix.test.XMLParsing.SAXParser;

import com.qulix.test.XMLParsing.XMLTags.SubTest;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SAX_TestConvert {

    private static ArrayList<SubTest> subTests;
    private static Handler handler;
    private static XMLReader reader;

    static {

        handler = new Handler();

        try{
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            System.err.println("A SAX Parser error: " + e);
        }
    }

    public static SAX_Test fromXML(String xmlInput){

        try{
            reader.parse(xmlInput);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       subTests =  handler.getSubTests();

       SAX_Test sax_test = new SAX_Test();
       sax_test.setTest(subTests);

       return sax_test;

    }

}
