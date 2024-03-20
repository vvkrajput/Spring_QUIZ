package com.Quiz.QuizService.service;

import com.Quiz.QuizService.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> get();

    Quiz get(Long id);
}
