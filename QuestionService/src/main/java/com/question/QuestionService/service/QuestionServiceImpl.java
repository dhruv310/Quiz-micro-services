package com.question.QuestionService.service;

import com.question.QuestionService.entity.Question;
import com.question.QuestionService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("No Question Found"));
    }

    @Override
    public List<Question> findByQuizId(Long id) {
        return questionRepository.findByQuizId(id);
    }
}
