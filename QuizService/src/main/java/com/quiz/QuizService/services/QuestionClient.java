package com.quiz.QuizService.services;


import com.quiz.QuizService.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8081" , value = "QuestionClient")
@FeignClient(name = "QUESTIONSERVICE")

public interface QuestionClient {


    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionQuiz(@PathVariable Long quizId);
}
