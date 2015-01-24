package com.qulix.test;

import com.qulix.test.XMLTags.Block;
import com.qulix.test.XMLTags.Elem;
import com.qulix.test.XMLTags.Param;
import com.qulix.test.XMLTags.SubTest;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;


public class Analyzer_DOM {

    public static ArrayList<SubTest> listBuilder(Element rootElement)
            throws SAXException, IOException {

        ArrayList<SubTest> subTests
                = new ArrayList<SubTest>();
        NodeList testNodes =
                rootElement.getElementsByTagName("test");
        SubTest subTest = null;

        for (int i = 0; i < testNodes.getLength(); i++) {

            subTest = new SubTest();
            Element testElement = (Element)testNodes.item(i);
            subTest.setName(testElement.getAttribute("name"));

            NodeList blockNodes =
                    testElement.getElementsByTagName("block");

            for (int j = 0; j < blockNodes.getLength(); j++) {

                Block block = subTest.createNewBlock();
                Element blockElement = (Element) blockNodes.item(j);
                block.setName(blockElement.getAttribute("name"));

                NodeList elementNodes =
                        blockElement.getElementsByTagName("element");


                for (int k = 0; k < elementNodes.getLength(); k++) {

                    Elem elem = block.createNewElem();
                    Element elemElement = (Element) elementNodes.item(k);
                    elem.setName(elemElement.getAttribute("name"));

                    NodeList paramsNodes = elemElement.getElementsByTagName("param");

                    for (int l = 0; l < paramsNodes.getLength(); l++) {

                        Param param = elem.createNewParam();
                        Element paramElement = (Element) paramsNodes.item(l);
                        param.setName(paramElement.getAttribute("name"));
                        param.setValue(paramElement.getAttribute("value"));
                        elem.addParam(param);
                    }
                 block.addElement(elem);

                }

              subTest.addBlock(block);
            }
            subTests.add(subTest);
        }

        return subTests;
    }

}
