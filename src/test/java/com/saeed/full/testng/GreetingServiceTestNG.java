package com.saeed.full.testng;

import com.saeed.full.service.GreetingService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GreetingServiceTestNG {
    private GreetingService greetingService;

    @BeforeMethod
    public void setup() {
        greetingService = new GreetingService();
    }

    @Test(description = "Greet specific name")
    public void greet_withName_returnsGreeting() {
        String result = greetingService.greet("TestNG");
        assertEquals(result, "Hello, TestNG!");
    }

    @Test(description = "Add two numbers with TestNG")
    public void add_twoNumbers_returnsSum() {
        int sum = greetingService.add(10, 15);
        assertEquals(sum, 25);
    }
}
