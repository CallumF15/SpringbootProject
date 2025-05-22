package com.example.springbootproject;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
