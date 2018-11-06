package com.github.uuidcode.java11.test.controller;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.uuidcode.java11.test.model.Project;

import static com.github.uuidcode.java11.test.util.CoreUtil.createUUID;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/")
    public Object index() {
        var projectList = IntStream.rangeClosed(1, 10)
            .boxed()
            .map(i -> Project.of().setName(createUUID()))
            .collect(Collectors.toList());

        return projectList;
    }

    @RequestMapping("/test")
    public void test(Model model) {
        var projectList = IntStream.rangeClosed(1, 10)
            .boxed()
            .map(i -> Project.of().setName(createUUID()))
            .collect(Collectors.toList());

        model.addAttribute("projectList", projectList);
    }
}
