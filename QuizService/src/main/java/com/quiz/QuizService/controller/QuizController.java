package com.quiz.QuizService.controller;


import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;


    @PostMapping("/add")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }


    @GetMapping("/getAll")
    public List<Quiz> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable  Long id)
    {
        return quizService.getById(id);
    }

}
