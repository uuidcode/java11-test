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

    public Project insert(Project project) {
        this.projectDao.insert(project);
        return this.select(project);
    }

    public int delete(Project project) {
        return this.projectDao.delete(project);
    }

    public Project update(Project project) {
        this.projectDao.update(project);
        return this.select(project);
    }

    public Project select(Project project) {
        return this.projectDao.select(project);
    }
}
