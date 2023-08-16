package com.exam.examserver.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.exam.Category;
import com.exam.examserver.entity.exam.Quiz;
import com.exam.examserver.repository.QuizRepository;
import com.exam.examserver.service.QuizService;

@Service
public class QuizServiceImpl  implements QuizService{

	@Autowired
	private QuizRepository quizrepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizrepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizrepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizrepository.findAll());
	}

	@Override
	public Quiz getQuiz(long quizid) {
		// TODO Auto-generated method stub
		return this.quizrepository.findById(quizid).get();
	}

	@Override
	public String deleteQuiz(long quizid) {
		// TODO Auto-generated method stub
		System.err.println("****************************************************");
		System.out.println( ((Object)quizid).getClass().getSimpleName());
	    this.quizrepository.deleteById(quizid);
		return "QUiz Deleted";
	}

	@Override
	public List<Quiz> findQuizByCategory(Category category) {
		// TODO Auto-generated method stub
		this.quizrepository.findByCategory(category);
		return null;
	}

	

	

	
}
