package com.qulix.test.XMLParsing.TestFolder;

import com.qulix.test.XMLParsing.Analyzer_DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class TestConvert {

    public final static String                  PATH                        = "D:\\!IdeaProjects\\Test\\src\\com\\qulix\\test\\XMLParsing\\data\\Test.xml";
    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY    = DocumentBuilderFactory.newInstance();
    private static final String                 TEXT_MESSAGE                = "Starting creation of a XML file";


    public static void main(String[] args) {

        try {

            Test test = fromXML(PATH);
            test.execute();
            System.out.println("\n*************");
            System.out.print(TEXT_MESSAGE);
            System.out.println("\n*************\n");
            System.out.println(test.serialize());
        }

        catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    public static Test fromXML(String xmlInput) throws ParserConfigurationException,IOException, SAXException  {


            DocumentBuilder documentBuilder = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();

            Document document = documentBuilder.parse(xmlInput);

            document.getDocumentElement().normalize();

            Element rootElement = document.getDocumentElement();

            Test test = new Test();

            test.setTest(Analyzer_DOM.listBuilder(rootElement));

         return test;
    }

}
