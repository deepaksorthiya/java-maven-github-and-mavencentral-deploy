package io.github.deepaksorthiya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {
        LOGGER.info("Hello World!");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}