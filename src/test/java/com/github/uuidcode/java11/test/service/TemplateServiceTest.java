package com.github.uuidcode.java11.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.uuidcode.java11.test.CoreTest;
import com.github.uuidcode.java11.test.model.Payload;
import com.github.uuidcode.java11.test.model.Project;

public class TemplateServiceTest extends CoreTest {
    protected static Logger logger = LoggerFactory.getLogger(TemplateServiceTest.class);

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void test() {
        List<Project> projectList = this.projectService.findAll();
        Payload payload = Payload.of().setProjectList(projectList);

        List<String> inputList = new ArrayList<>();
        inputList.add("<ul>");
        inputList.add("{{#each projectList}}");
        inputList.add("<li>{{name}}</li>");
        inputList.add("{{/each}}");
        inputList.add("</ul>");

        String input = inputList.stream().collect(Collectors.joining("\n"));

        String inlineResult = this.templateService.applyInline(input, payload);

        if (logger.isDebugEnabled()) {
            logger.debug(">>> client inlineResult: {}", inlineResult);
        }

        String result = this.templateService.applyFile("server", payload);

        if (logger.isDebugEnabled()) {
            logger.debug(">>> client result: {}", result);
        }
    }
}