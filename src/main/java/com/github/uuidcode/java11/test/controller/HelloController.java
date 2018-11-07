package com.github.uuidcode.java11.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.github.uuidcode.java11.test.model.Payload;
import com.github.uuidcode.java11.test.model.Project;
import com.github.uuidcode.java11.test.service.ProjectService;
import com.github.uuidcode.java11.test.service.TemplateService;

import reactor.core.publisher.Mono;

import static com.github.uuidcode.java11.test.util.CoreUtil.createUUID;

@Controller
public class HelloController {
    protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TemplateService templateService;

    private List<Project> createProjectList() {
        return IntStream.rangeClosed(1, 10)
            .boxed()
            .map(i -> Project.of().setName(createUUID()))
            .collect(Collectors.toList());
    }

    private Payload createPayload() {
        return Payload.of().setProjectList(this.createProjectList());
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/client";
    }

    @ResponseBody
    @RequestMapping("/api")
    public Object api() {
        return this.createPayload();
    }

    @RequestMapping("/server")
    public void server(Model model) {
        model.addAttribute("projectList", this.createProjectList());
    }

    @RequestMapping("/client")
    public void client() throws Exception {
    }

    @ResponseBody
    @GetMapping("/webClient")
    public Mono<String> webClient() {
        WebClient client = WebClient.builder().build();

        return client.get()
            .uri("https://jsonplaceholder.typicode.com/todos/1")
            .retrieve()
            .bodyToMono(String.class)
            .map(body -> body.toUpperCase())
            .switchIfEmpty(Mono.just("Empty"));
    }
}
