package com.exam.examserver.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;
import com.exam.examserver.repository.QuestionRepository;
import com.exam.examserver.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionrepository;

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionrepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionrepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionrepository.findAll());
	}

	@Override
	public Question getQuestion(long id) {
		// TODO Auto-generated method stub
		return this.questionrepository.findById(id).get();
	}

	@Override
	public String deleteQuestion(long id) {
		// TODO Auto-generated method stub
		this.questionrepository.deleteById(id);
		return "QUESTION DELETED";
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionrepository.findByQuiz(quiz));
	}

}
