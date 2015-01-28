package com.qulix.test.XMLParsing.SAXParser;

import com.qulix.test.XMLParsing.XMLTags.Block;
import com.qulix.test.XMLParsing.XMLTags.Elem;
import com.qulix.test.XMLParsing.XMLTags.SubTest;
import org.apache.commons.lang3.StringUtils;

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
}
