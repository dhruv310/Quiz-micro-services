package com.question.QuestionService.controller;

import com.question.QuestionService.entity.Question;
import com.question.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @GetMapping("/getAll")
    public List<Question> getAll()
    {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getById(id);
    }


    @PostMapping("/add")
    public Question add(@RequestBody Question question){
        return questionService.add(question);
    }


    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.findByQuizId(quizId);
    }


}
