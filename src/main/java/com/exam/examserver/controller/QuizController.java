package com.exam.examserver.controller;

import java.util.List;
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

import com.exam.examserver.entity.exam.Category;
import com.exam.examserver.entity.exam.Quiz;
import com.exam.examserver.service.QuizService;



@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizservice;

	// add the Quiz
	@PostMapping("/add")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return this.quizservice.addQuiz(quiz);
	}

	// get Quiz details by ID
	@GetMapping("/getQuiz/{id}")
	public Quiz getQuizById(@PathVariable("id") int id) {
		return this.quizservice.getQuiz(id);
	}

	// get all Quizes
	@GetMapping("/quizes")
	public Set<Quiz> getQuizes() {
		return this.quizservice.getQuizes();
	}

	// update Quiz Details
	@PutMapping("/update")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizservice.updateQuiz(quiz);
	}

	// Delete Quiz by Quiz id
	@DeleteMapping("/delete/{id}")
	public long deleteQuiz(@PathVariable("id") long id) {

		this.quizservice.deleteQuiz(id);
		return id;
	}
    
	@GetMapping("/find")
	public List<Quiz> findAllQuiz(@RequestBody  Category category)
	{
		return this.quizservice.findQuizByCategory(category);
	}
	
}
