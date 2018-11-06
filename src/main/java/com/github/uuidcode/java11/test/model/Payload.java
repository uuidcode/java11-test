package com.github.uuidcode.java11.test.model;

import java.util.List;

public class Payload {
    private List<Project> projectList;

    public static Payload of() {
        return new Payload();
    }

    public List<Project> getProjectList() {
        return this.projectList;
    }

    public Payload setProjectList(List<Project> projectList) {
        this.projectList = projectList;
        return this;
    }
}
