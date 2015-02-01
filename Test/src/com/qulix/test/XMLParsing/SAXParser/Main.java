package com.qulix.test.XMLParsing.SAXParser;

import java.io.IOException;

public class Main {
    public final static String PATH = "./src/com/qulix/test/XMLParsing/data/Test.xml";

    public static void main(String[] args) throws IOException {

        SAX_Test test = SAX_TestConvert.fromXML(PATH);
        test.execute();
        System.out.println("\n********* Starting XML creation *********\n");
        test.serialize();
    }


}

