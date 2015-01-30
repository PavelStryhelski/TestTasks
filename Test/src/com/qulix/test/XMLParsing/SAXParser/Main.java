package com.qulix.test.XMLParsing.SAXParser;

public class Main {
    public final static String PATH = "./Test/src/com/qulix/test/XMLParsing/data/Test.xml";

    public static void main(String[] args) {

        SAX_Test test = SAX_TestConvert.fromXML(PATH);
        test.execute();
        test.serialize();
    }


}
