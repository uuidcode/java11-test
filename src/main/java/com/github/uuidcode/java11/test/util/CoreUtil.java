package com.github.uuidcode.java11.test.util;

import java.util.UUID;

public class CoreUtil {
    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
