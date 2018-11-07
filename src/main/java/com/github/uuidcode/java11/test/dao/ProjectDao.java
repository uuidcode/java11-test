package com.github.uuidcode.java11.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.uuidcode.java11.test.model.Project;

@Repository
public interface ProjectDao {
    List<Project> findAll();
    int insert(Project project);
}
