package com.qulix.test.XMLParsing.TestFolder;


import com.qulix.test.XMLParsing.XMLTags.Block;
import com.qulix.test.XMLParsing.XMLTags.Elem;
import com.qulix.test.XMLParsing.XMLTags.Param;
import com.qulix.test.XMLParsing.XMLTags.SubTest;
import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.util.ArrayList;


public class Test {

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


    public String serialize() {

        Format format = Format.getPrettyFormat();
        format.setEncoding("windows-1251");
        XMLOutputter outPutter = new XMLOutputter(format);


        org.jdom2.Element rootElement = new org.jdom2.Element("root");
        Document doc = new Document();
        doc.setRootElement(rootElement);

        for (SubTest st : subtests) {

            org.jdom2.Element testElement = new org.jdom2.Element("test");
            org.jdom2.Element blocksElement = new org.jdom2.Element("blocks");

            testElement.setAttribute("name", st.getName());


            rootElement.addContent(testElement);
            testElement.addContent(blocksElement);

            for (Block bl : st.getBlockCollection()) {

                org.jdom2.Element blockElement = new org.jdom2.Element("block");
                org.jdom2.Element elementsElement = new org.jdom2.Element("elements");

                blockElement.setAttribute("name", bl.getName());

                blocksElement.addContent(blockElement);
                blockElement.addContent(elementsElement);

                for (Elem el : bl.getElemCollection()) {

                    org.jdom2.Element elemElement = new org.jdom2.Element("element");
                    elemElement.setAttribute("name", el.getName());
                    elementsElement.addContent(elemElement);

                    for (Param par : el.getParamCollection()) {

                        org.jdom2.Element paramElement = new org.jdom2.Element("param");
                        paramElement.setAttribute("name", par.getName());
                        paramElement.setAttribute("value", par.getValue());
                        elemElement.addContent(paramElement);
                    }
                }
            }
        }

        return outPutter.outputString(doc);

    }

}
