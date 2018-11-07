package com.github.uuidcode.java11.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.uuidcode.java11.test.dao.ProjectDao;
import com.github.uuidcode.java11.test.model.Project;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    public List<Project> findAll() {
        return this.projectDao.findAll();
    }

    public int insert(Project project) {
        return this.projectDao.insert(project);
    }
}
