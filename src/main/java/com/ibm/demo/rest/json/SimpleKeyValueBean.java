package com.ibm.demo.rest.json;

public class SimpleKeyValueBean {

    public String name;
    public String value;

    public SimpleKeyValueBean() {
    }

    public SimpleKeyValueBean(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }
}