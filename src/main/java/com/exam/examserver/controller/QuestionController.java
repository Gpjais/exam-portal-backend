package com.exam.examserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;
import com.exam.examserver.service.QuestionService;
import com.exam.examserver.service.QuizService;

@RestController
@RequestMapping("/Question")
@CrossOrigin("*")
public class QuestionController {
  
	    @Autowired
	    private QuestionService questionservice;
 
	    @Autowired
	    private QuizService quizservice;
	    
	    @PostMapping("/add")
	    public Question addQuestion(@RequestBody Question question)
	    {
	    	return this.questionservice.addQuestion(question);
	    }
	    
	    @PutMapping("/update")
	    public Question updateQuestion(@RequestBody Question question)
	    {
	    	return this.questionservice.updateQuestion(question);
	    }
	    
	    @GetMapping("quiz/{id}")
	    public Set<Question> getQuestionbyQuizId(@PathVariable("id") long id)
	    {
	    	Quiz quiz=quizservice.getQuiz(id);
	    	return this.questionservice.getQuestionOfQuiz(quiz);
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public void deletebyId(@PathVariable("id") long id)
	    {
	    	this.questionservice.deleteQuestion(id);
	    }
} 
