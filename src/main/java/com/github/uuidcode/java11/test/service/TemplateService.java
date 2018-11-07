package com.github.uuidcode.java11.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;

@Service
public class TemplateService {
    @Autowired
    private HandlebarsViewResolver handlebarsViewResolver;

    public String applyInline(String input, Object object) {
        try {
            return this.handlebarsViewResolver.getHandlebars()
                .compileInline(input)
                .apply(object);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public String applyFile(String file, Object object) {
        try {
            return this.handlebarsViewResolver.getHandlebars()
                .compile(file)
                .apply(object);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
