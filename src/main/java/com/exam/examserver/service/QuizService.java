package com.exam.examserver.service;

import java.util.List;
import java.util.Set;

import com.exam.examserver.entity.exam.Category;
import com.exam.examserver.entity.exam.Quiz;


public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizes();
	
	public Quiz getQuiz(long quizid);
	
	public String deleteQuiz(long quizid);
	
	public List<Quiz> findQuizByCategory(Category category);
	
	
	
	
	
	

}
