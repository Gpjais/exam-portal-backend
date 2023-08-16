package com.exam.examserver.service;

import java.util.Set;

import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;


public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestion(long id);

	public String deleteQuestion(long id);
	
	public Set<Question>  getQuestionOfQuiz(Quiz quiz );
}
