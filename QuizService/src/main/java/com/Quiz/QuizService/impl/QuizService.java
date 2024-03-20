package com.Quiz.QuizService.impl;

import com.Quiz.QuizService.entities.Quiz;
import com.Quiz.QuizService.repositories.QuizRepository;
import com.Quiz.QuizService.service.QuestionClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService implements com.Quiz.QuizService.service.QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizService(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes =  quizRepository.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz ->{
             quiz.setQuestions(questionClient.getQuestionOfQUiz(quiz.getId()));
             return quiz;
         }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz =  quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not Found"));
    quiz.setQuestions(questionClient.getQuestionOfQUiz(id));
    return quiz;
    }
}
