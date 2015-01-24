package com.qulix.test.XMLParsing.SAXParser;

public enum TestEnum {
    TESTS ("tests"),
    NAME("name"),
    VALUE("value"),
    TEST("test"),
    BLOCKS("blocks"),
    BLOCK("block"),
    ELEMENTS("elements"),
    ELEMENT("element"),
    PARAM("param");

    private String value;

    private TestEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
