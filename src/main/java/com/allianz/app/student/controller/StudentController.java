package com.allianz.app.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @GetMapping
    public String sayHello() {
        return "Hello World!";
    }

}
