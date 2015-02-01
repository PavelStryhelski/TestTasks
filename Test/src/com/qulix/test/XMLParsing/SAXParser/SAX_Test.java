package com.qulix.test.XMLParsing.SAXParser;

import com.qulix.test.XMLParsing.XMLTags.Tests;
import com.qulix.test.XMLParsing.XMLTags.Block;
import com.qulix.test.XMLParsing.XMLTags.Elem;
import com.qulix.test.XMLParsing.XMLTags.SubTest;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SAX_Test {

    private ArrayList<SubTest> subtests;

    public ArrayList<SubTest> getTest() {
        return subtests;
    }

    public void setTest(ArrayList<SubTest> subtests) {
        this.subtests = subtests;
    }

    public void execute() {

        for (SubTest st : subtests) {
            System.out.println("Test " + st + " started");

            for (Block bl : st.getBlockCollection()) {

                System.out.println("\tBlock " + bl + " started");

                for (Elem el : bl.getElemCollection()) {

                    System.out.println("\t\t" + el + "(" + StringUtils.join(el.getParamCollection(), ", ") + ")");

                }

                System.out.println("\tBlock " + bl + " ended");

            }

            System.out.println("Test " + st + " ended");
        }
    }

    public void serialize() throws IOException {

        Tests tests = new Tests();
        tests.setSubTests(subtests);
        OutputStream outputStream = new BufferedOutputStream(System.out);

        try {
            JAXBContext context =
                    JAXBContext.newInstance(Tests.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            m.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"windows-1251\"?>");
            m.marshal(tests, outputStream);
        } catch (JAXBException e) {
            System.out.println("JAXB-исключения");
            e.printStackTrace();
        }
        finally {
            outputStream.close();
        }
    }

}
