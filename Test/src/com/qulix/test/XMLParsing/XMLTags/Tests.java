package com.qulix.test.XMLParsing.XMLTags;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement (name = "root")
public class Tests {

    private ArrayList<SubTest> subTests;

    public ArrayList<SubTest> getSubTests() {
        return subTests;
    }

    @XmlElement(name = "test")
    public void setSubTests(ArrayList<SubTest> subTests) {
        this.subTests = subTests;
    }

}
