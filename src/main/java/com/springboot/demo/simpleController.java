package com.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class simpleController {

    @GetMapping("/helloWorld")
    public String getString() {
        return "Hello World from Controller";
    }
}
