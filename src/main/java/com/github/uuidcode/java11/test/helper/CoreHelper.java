package com.github.uuidcode.java11.test.helper;

import org.slf4j.Logger;

import com.github.uuidcode.java11.test.util.CoreUtil;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

import static java.util.Optional.ofNullable;
import static org.slf4j.LoggerFactory.getLogger;

@HandlebarsHelper
public class CoreHelper {
    protected static Logger logger = getLogger(CoreHelper.class);

    public String uuid() {
        return CoreUtil.createUUID();
    }

    public String length(String value) {
        if (logger.isDebugEnabled()) {
            logger.debug(">>> length value: {}", value);
        }

        return ofNullable(value)
            .map(String::length)
            .map(String::valueOf)
            .orElse("0");
    }
}
