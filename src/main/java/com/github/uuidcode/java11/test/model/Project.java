package com.github.uuidcode.java11.test.model;

public class Project {
    private String name;
    private Long projectId;

    public Long getProjectId() {
        return this.projectId;
    }

    public Project setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

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
