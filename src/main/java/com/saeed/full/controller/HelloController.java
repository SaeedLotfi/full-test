package com.saeed.full.controller;

import com.saeed.full.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        // Delegate to service (easy to unit-test)
        return greetingService.greet(name);
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return greetingService.add(a, b);
    }
}
