package com.github.uuidcode.java11.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.uuidcode.java11.test.model.Project;
import com.github.uuidcode.java11.test.service.ProjectService;

import static com.github.uuidcode.java11.test.util.CoreUtil.createUUID;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public void index(Model model) {
        List<Project> projectList = this.projectService.findAll();
        model.addAttribute("projectList", projectList);
    }

    @ResponseBody
    @PostMapping("/project")
    public Object add(@RequestBody Project project) {
        return this.projectService.insert(project.setName(createUUID()));
    }
}
