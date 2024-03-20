package com.Quiz.QuizService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-test")

public class TestController {
    @GetMapping("/test")
    public String show(){
        return "Test Calling";
    }
}
