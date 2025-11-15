package com.saeed.full.junit;

import com.saeed.full.service.GreetingService;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Greeting Service")
@Feature("Unit tests")
public class GreetingServiceTest {

    private GreetingService greetingService;

    @BeforeEach
    void setup() {
        greetingService = new GreetingService();
    }

    @Test
    @Story("Greet with name")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Should greet user with given name")
    void should_greetWithName_returnsGreeting() {
        String result = greetingService.greet("Saeed");
        assertEquals("Hello, Saeed!", result);
    }

    @Test
    void greet_blankName_returnsAnonymous() {
        String result = greetingService.greet(null);
        assertEquals("Hello, Anonymous!", result);
    }

    @Test
    void add_twoNumbers_returnsSum() {
        int sum = greetingService.add(2,4);
        assertEquals(6,sum);
    }
}
