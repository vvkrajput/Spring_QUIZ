package com.Quiz.QuizService.service;


import com.Quiz.QuizService.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//@FeignClient(url = "http://localhost:8082", value="Question-Client")

@FeignClient(name="QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("question/quiz/{quizid}")
    List<Question> getQuestionOfQUiz(@PathVariable Long quizid);

}
