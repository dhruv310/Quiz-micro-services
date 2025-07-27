package com.quiz.QuizService.services;

import com.quiz.QuizService.entity.Quiz;
import com.quiz.QuizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();

        quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return quizzes;
    }

    @Override
    public Quiz getById(Long id) {
        Quiz quizObj =  quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
        quizObj.setQuestions(questionClient.getQuestionQuiz(quizObj.getId()));
        return quizObj;
    }



}
