package com.github.uuidcode.java11.test.model;

public class Project {
    private String name;

    public static Project of() {
        return new Project();
    }

    public String getName() {
        return this.name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }
}
