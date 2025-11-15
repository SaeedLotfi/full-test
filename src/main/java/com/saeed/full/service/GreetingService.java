package com.saeed.full.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greet(String name) {
        // Basic null / blank handling
        if (name == null || name.isBlank()) {
            return "Hello, Anonymous!";
        }
        return "Hello, " + name + "!";
    }

    public int add(int a, int b) {
        return a + b;
    }
}
