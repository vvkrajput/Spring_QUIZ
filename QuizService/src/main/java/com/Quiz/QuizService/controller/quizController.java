package com.Quiz.QuizService.controller;


import com.Quiz.QuizService.entities.Quiz;
import com.Quiz.QuizService.impl.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class quizController {

    private QuizService quizService;

    public quizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //create
    @PostMapping()
    public Quiz Create(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    //show
    @GetMapping("/show")
    public List<Quiz> Show() {
        return quizService.get();
    }

    //show By Id
    @GetMapping("/{id}")
    public Quiz showByID(@PathVariable Long id){
        return quizService.get(id);
    }
}